import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Emergency {
	
	public final static boolean DEBUG_PRINT = false;
	
	public static class Patient implements Comparable<Patient> {
		public int num;
		public long arrive;
		public long availableAt;
		public int severity;
		public long doctorStart;
		public long leave;
		
		private int compareAvailableAt(Patient o) {
			if (availableAt > o.availableAt) {
				return 1;
			}
			else if (availableAt == o.availableAt){
				return 0;
			}
			else {
				return -1;
			}
		}
		
		public int compareTo(Patient o) {
			int comp = compareAvailableAt(o);
			if (comp == 0) { 
				if (severity > o.severity) {
					return -1;
				}
				else if (severity == o.severity) {
					return compareAvailableAt(o);
				}
				else {
					return 1;
				}
			}
			else {
				return comp;
			}
		}
	}
	
	public static class Doctor {
		public long availableAt;
	}
       
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("emergency.dat"));
        
        final int scenarios = Integer.parseInt(kb.nextLine().trim());
        for (int s = 0; s < scenarios; ++s) {
        	String[] tokens = kb.nextLine().trim().split(" ");
        	final int entries = Integer.parseInt(tokens[0]);
        	final int minTime = Integer.parseInt(tokens[1]);
        	
        	Patient[] patients = new Patient[entries];
        	for (int e = 0; e < entries; ++e) {
        		tokens = kb.nextLine().trim().split(" ");
        		String[] timeParts = tokens[0].split(":");
        		
        		patients[e] = new Patient();
        		patients[e].arrive = 60 * Long.parseLong(timeParts[0]) + Long.parseLong(timeParts[1]);
        		patients[e].severity = Integer.parseInt(tokens[1]);
        		patients[e].num = e + 1;
        		
        		patients[e].availableAt = patients[e].arrive;
        		
        		if (patients[e].severity < 8) {
        			patients[e].availableAt += 5;
        		}
        	}
        	
        	// Sort patients by arrival since we modified their start time
        	Arrays.sort(patients);
        	
        	int numDoctors = 3;
        	boolean bDone = false;
        	while (!bDone) {
        		PriorityQueue<Patient> waiting = new PriorityQueue<Patient>();
        		Doctor[] doctors = new Doctor[numDoctors];
        		for (int d = 0; d < numDoctors; ++d) {
        			doctors[d] = new Doctor();
        		}
        		
        		if (DEBUG_PRINT)
        			System.out.printf("TRYING %d DOCTORS\n", numDoctors);
        		
        		int curPatient = 0;
        		long curTime = 0;
        		while (curPatient < patients.length || !waiting.isEmpty()) {
        			long nextPatientArrive = (curPatient < patients.length) ? patients[curPatient].availableAt : Long.MAX_VALUE;
        			long doctorAvailable = Long.MAX_VALUE;
        			for (int d = 0; d < numDoctors; ++d) {
        				if (doctors[d].availableAt < doctorAvailable)
        					doctorAvailable = doctors[d].availableAt;
        			}
        			
        			if (nextPatientArrive <= doctorAvailable) {
        				// Patients arrive until doctor is ready
            			while (nextPatientArrive <= doctorAvailable) {
            				Patient p = patients[curPatient++];
            				waiting.add(p);
            				
            				if (DEBUG_PRINT)
            					System.out.printf("** PATIENT %d AVAILABLE AT %d:%d\n", p.num, nextPatientArrive / 60, nextPatientArrive % 60);
            				
            				nextPatientArrive = (curPatient < patients.length) ? patients[curPatient].availableAt : Long.MAX_VALUE;
            			}
        			}
        			else if (curPatient < patients.length) {
        				Patient p = patients[curPatient++];
        				waiting.add(p);
        				
        				if (DEBUG_PRINT)
        					System.out.printf("** PATIENT %d AVAILABLE AT %d:%d\n", p.num, nextPatientArrive / 60, nextPatientArrive % 60);
        				
        				doctorAvailable = p.availableAt;
        				nextPatientArrive = (curPatient < patients.length) ? patients[curPatient].availableAt : Long.MAX_VALUE;
        			}
        			
        			curTime = doctorAvailable;
        			
        			// Grab patients
        			for (int d = 0; d < numDoctors; ++d) {
            			if (doctors[d].availableAt <= curTime) {
            				Patient p = waiting.poll();
            				if (p != null) {
            					p.doctorStart = curTime;
            					
            					if (DEBUG_PRINT)
            						System.out.printf("** PATIENT %d SEEN AT %d:%d\n", p.num, curTime / 60, curTime % 60);
            					
            					p.leave = (long) (curTime + (p.severity * 8));
            					doctors[d].availableAt = p.leave;
            				}
            			}
            		}
        		}
        		
        		int weightedSum = 0;
        		for (int e = 0; e < entries; ++e) {
        		   weightedSum += (patients[e].doctorStart - patients[e].arrive);
        		}
        		        		
        		float avg = weightedSum / (float) entries;
        		if (avg <= minTime) {
        		   bDone = true;
        		}
        		else {
        		   ++numDoctors;
        		}
        		
        		if (DEBUG_PRINT)
        			System.out.printf("** SUM %d AVG %f\n", weightedSum, avg);
        	}
        	
        	System.out.printf("%d doctors\n", numDoctors);
        	
        	if (DEBUG_PRINT)
        		System.out.println("=======================================");
        }
    }    
}

