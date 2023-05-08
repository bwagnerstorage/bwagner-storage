import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Family {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner read1 = new Scanner (new File ("family.dat"));
		int noLines = read1.nextInt();
		read1.nextLine();
		Map<String, Person> family = getPersons(read1, noLines);
		read1.close();
		Scanner read2 = new Scanner (new File ("family.dat"));
		getFamily(read2, noLines, family);
		for (Person p: family.values()) {
			System.out.println(p);
		}
	}
	
	public static Map<String, Person> getPersons (Scanner reader, int howMany) {
		Map<String, Person> names = new TreeMap<String, Person>();
		for (int i = 0; i < howMany; i++) {
			Scanner linesc = new Scanner(reader.nextLine());
			String name = linesc.next();
			if (!names.containsKey(name)) {
				names.put(name, new Person(name));
			}
			linesc.next();
			name = linesc.next();
			if (!names.containsKey(name)) {
				names.put(name, new Person(name));
			}
		}	
		// System.out.println(names.keySet().toString());
		// System.out.println(names.values().toString());
		return names;
	}
	
	public static void getFamily(Scanner reader, int howMany, Map<String,Person> family) {
		reader.nextLine(); // throw away number at beginning
		for (int i = 0; i < howMany; i++) {
			Scanner linesc = new Scanner(reader.nextLine());
			String name1 = linesc.next();
			String rel = linesc.next();
			String name2 = linesc.next();
			linesc.close();
			for (String name: family.keySet()) {
				if (name.equals(name1)){
					Person p1 = family.get(name1);
					Person p2 = family.get(name2);
					if (rel.equals("father")) {
						p1.father = p2;
					}
					if (rel.equals("mother")) {
						p1.mother = p2;
					}
					if (rel.equals("sibling")) {
						p1.siblings.add(p2);
						for (Person p: p1.siblings) {
							p.siblings.add(p1);
						}
					}
				}
			}
		}
	}
}

class Person implements Comparable {
	String name;
	Person father;
	Person mother;
	Set<Person> siblings;
	
	public Person (String name) {
		this.name = name;
		siblings = new TreeSet<Person>();
	}
	
	public String toString () {
		String s = name + "\n";
		if (father!= null) {
			s += "Father: " + father.name + "\n";
		} else {
			s+= "Father: Unknown\n";
		}
		if (mother!= null) {
			s += "Mother: " + mother.name + "\n";
		} else {
			s+= "Mother: Unknown\n";
		}
		if (siblings != null) {
			for (Person p: siblings) {
				s += "Sibling: " + p.name + "\n";
			}
		}		
		return s;
	}
	
	public boolean equals(Person p) {
		return this.name.equals(p.name);
	}
	
	public int compareTo(Object o) {
		if (!(o instanceof Person)) return -1;
		Person p = (Person)o;
		return this.name.compareTo(p.name);
	}
}
