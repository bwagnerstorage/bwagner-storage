import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;

public class CommonNames {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner (new File ("commonnames.dat"));
		Map<String, Integer> namesMap;
		int testcases = reader.nextInt();
		reader.nextLine();
		for (int i = 0; i < testcases; i++ ) {
			String testcase = reader.nextLine();
			namesMap = getCountMap(testcase);
			//System.out.println(namesMap.toString());
			printNames(getModes(namesMap));
		}		
	}
	
	/*
	 * Convert testcase to a count TreeMap
	 */	
	public static Map<String, Integer> getCountMap (String testcase) {
		Map<String, Integer> namesMap = new TreeMap<String, Integer>();
		Scanner sc = new Scanner (testcase);
		while (sc.hasNext()) {
			String name = sc.next();
			if (namesMap.keySet().contains(name)) {
				Integer count = namesMap.get(name);
				namesMap.put(name, count + 1);
			} else {
				namesMap.put(name, 1);
			}
		}
		return namesMap;
	}
	
	/* 
	 * Return an array of the most frequently occurring names
	 */
	public static ArrayList<String> getModes(Map<String, Integer> nameCountMap) {
		ArrayList<String> modes = new ArrayList<String>();
		int max = 1;
		// get highest occurring value
		for (String s: nameCountMap.keySet()) {
			if (nameCountMap.get(s) > max) max = nameCountMap.get(s);
		}
		// get modes
		for (String s: nameCountMap.keySet()) {
			if (nameCountMap.get(s) == max) modes.add(s);
		}
		return modes;	
	}
	
	/*
	 * Print the output names.
	 */
	public static void printNames(ArrayList<String> a) {
		String space = "";
		for (String s: a) {
			System.out.print(space + s);
			space = " ";
		}
		System.out.println();
	}
}
