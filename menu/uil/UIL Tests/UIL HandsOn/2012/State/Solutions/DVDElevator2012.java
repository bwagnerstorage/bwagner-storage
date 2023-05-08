import java.io.*;
import java.util.*;


public class DVDElevator2012 {
    public static final long MILLISECONDS_TO_MICROSECONDS = 1000;
    public static final long MICROSECONDS_PER_BATCH = 10 * MILLISECONDS_TO_MICROSECONDS;
    
    public static class ReadRequest implements Comparable<ReadRequest> {
        public long mSectorStart;
        public long mSectorEnd;
        
        public int compareTo(ReadRequest o) {
            long diff = this.mSectorStart - o.mSectorStart;
            if (diff < 0) {
                return -1;
            }
            else if (diff > 0) {
                return 1;
            }
            else {
                return 1;
            }
        }
    }
    
    public static void main(String args[]) throws IOException
    {
    	Scanner kb = new Scanner(new File("dvdelevator2012.dat"));
    	
        long batchEndMicrosecond = 0;
        long laserPos = 0;
        
        PriorityQueue<ReadRequest> batch = new PriorityQueue<ReadRequest>();
        
        while (kb.hasNextLine()) {
            String strLine = kb.nextLine();
            
            String[] strArr = strLine.split(" ");
            
            long startTimeMicroseconds = Long.parseLong(strArr[0]);
            long sectorStart = Long.parseLong(strArr[1]);
            long sectorEnd = Long.parseLong(strArr[2]);
            
            if (batchEndMicrosecond !=0 && startTimeMicroseconds > batchEndMicrosecond) {
            	while (!batch.isEmpty()) {
            		ReadRequest req = batch.remove();
            		System.out.printf("Time %d: %d to %d\n", batchEndMicrosecond, req.mSectorStart, req.mSectorEnd);
            		laserPos = req.mSectorEnd + 1;
            	}
            	
            	batchEndMicrosecond = 0;
            }
            
            if (sectorStart >= laserPos) {
            	System.out.printf("Time %d: %d to %d\n", startTimeMicroseconds, sectorStart, sectorEnd);
            	laserPos = sectorEnd + 1;
            }
            else {
            	if (batchEndMicrosecond == 0) {
            		batchEndMicrosecond = startTimeMicroseconds + MICROSECONDS_PER_BATCH;
            	}
            	
            	ReadRequest req = new ReadRequest();
            	req.mSectorStart = sectorStart;
            	req.mSectorEnd = sectorEnd;
            	batch.add(req);
            }
        }
        
        if (batchEndMicrosecond !=0) {
        	while (!batch.isEmpty()) {
        		ReadRequest req = batch.remove();
        		System.out.printf("Time %d: %d to %d\n", batchEndMicrosecond, req.mSectorStart, req.mSectorEnd);
        		laserPos = req.mSectorEnd + 1;
        	}
        }
    }
}
