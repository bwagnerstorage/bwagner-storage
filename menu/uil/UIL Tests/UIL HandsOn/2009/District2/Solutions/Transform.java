
import java.io.*;
import java.util.*;

public class Transform {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("transform.dat"));
        int numLines = s.nextInt();
        int[] bases = {2, 3, 5, 7};
        int currentBaseIndex = 0;
        s.nextLine();
        String line;
        int ch;
        for(int i = 1; i <= numLines; i++){
            line = s.nextLine();
            for(int j = 0; j < line.length() - 1; j++){
                ch = line.charAt(j);
                System.out.print( toBase(ch, bases[currentBaseIndex]) + "_");
            }
            ch = line.charAt(line.length() - 1);
            // could use Integer
            System.out.println( Integer.toString(ch, bases[currentBaseIndex]) );
            currentBaseIndex = (currentBaseIndex + 1) % bases.length;
        }
    }

    // if not aware of Integer.toString(int, int)
    /*
     * pre: none
     * post: returns a String with base10Num in given base
     */
    public static String toBase(int base10Num, int base){
        boolean isNeg = base10Num < 0;
        base10Num = Math.abs(base10Num);
        String result = "";

        while(base10Num > base - 1){
            result = (base10Num % base) + result;
            base10Num /= base;
        }

        result = base10Num + result;

        if( isNeg )
            result = "-" + result;
        return result;
    }
}


