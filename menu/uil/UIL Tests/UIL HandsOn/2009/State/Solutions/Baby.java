import java.io.File;
import java.io.IOException;
import java.util.*;

public class Baby {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("baby.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        for(int i = 1; i <= numSets; i++){
            System.out.println(i);
            int names = s.nextInt();
            s.nextLine();
            Map<String, Integer>usedNames = new HashMap<String, Integer>();
            for(int j = 0; j < names; j++){
                String name = s.nextLine().trim();
                String nameAsLowerCase = name.toLowerCase();
                if(usedNames.containsKey(nameAsLowerCase)){                    
                    String newName = name + (usedNames.get(nameAsLowerCase) + 1);
                    usedNames.put(nameAsLowerCase, usedNames.get(nameAsLowerCase) + 1);
                    System.out.println(newName);
                }
                else{
                    usedNames.put(nameAsLowerCase, 1);
                    System.out.println(name);
                }
            }
        }
        s.close();
    }
}
