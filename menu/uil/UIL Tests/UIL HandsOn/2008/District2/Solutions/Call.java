import java.io.File;
import java.io.IOException;
import java.util.*;

public class Call {

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("call.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            String number = s.nextLine();
            Map<Character, String> codes = new HashMap<Character, String>();
            for(int j = 0; j < 10; j++){
                String[] code = s.nextLine().split("\\s+");
                codes.put(code[0].charAt(0), code[1]);
            }
            TreeSet<String> mnemonics = new TreeSet<String>();
            generateMnemonics(number, codes, mnemonics);
            System.out.println("Mnemonics for " + number + ":");
            for(String mn : mnemonics)
                System.out.println(mn);
        }
    }

    private static void generateMnemonics(
        String number,
        Map<Character, String> codes, 
            TreeSet<String> mnemonics) {
        recur(number, "", codes, mnemonics);
    }

    private static void recur(
         String number, 
         String result,
         Map<Character, String> codes, 
            TreeSet<String> mnemonics) {
        if(number.length() == 0)
            mnemonics.add(result);
        else{
            String options = codes.get(number.charAt(0));
            for(int i = 0; i < options.length(); i++)
                recur(number.substring(1), result + options.charAt(i),
                        codes, mnemonics);
                
        }
    }
    
    
}
