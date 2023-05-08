import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TreeDecompression {
    
    public static byte binaryStringToByte(String s) {
        return (byte) ( Character.digit(s.charAt(0), 2) << 7
                      | Character.digit(s.charAt(1), 2) << 6
                      | Character.digit(s.charAt(2), 2) << 5
                      | Character.digit(s.charAt(3), 2) << 4
                      | Character.digit(s.charAt(4), 2) << 3
                      | Character.digit(s.charAt(5), 2) << 2
                      | Character.digit(s.charAt(6), 2) << 1
                      | Character.digit(s.charAt(7), 2) << 0);
    }
    
    public static String byteToBinary(byte b) {
        final byte MASK = (byte) 0x80;
        
        String str = "";
        for (int i = 0; i < 8; ++i) {
            if (0 == (b & MASK)) {
                str += "0";
            }
            else {
                str += "1";
            }
            
            b <<= 1;
        }
        
        return str;
    }
       
    public static void main(String args[]) throws IOException
    {
        Scanner kb = new Scanner(new File("treedecompression.dat"));
        
        while (kb.hasNext()) {
            String line = kb.nextLine().trim();
            byte count = binaryStringToByte(line);
            line = line.substring(8);
            
            if (count == 0) {
                for (int a = 0; a < line.length(); a += 8) {
                    System.out.print((char) binaryStringToByte(line.substring(a)));
                }
                
                System.out.println();
            }
            else {
                char[] charList = new char[count];
                for (int i = 0; i < count; ++i) {
                    charList[i] = (char) binaryStringToByte(line);
                    line = line.substring(8);
                }
                
                char[] chars = line.toCharArray();
                String tmp = "";
                for (int c = 0; c < chars.length; ++c) {
                    char ch = chars[c];
                    
                    if (ch == '0') {
                        System.out.print(charList[tmp.length()]);
                        tmp = "";
                    }
                    else {
                        tmp += "1";
                        
                        if (tmp.length() == (charList.length - 1)) {
                            System.out.print(charList[charList.length - 1]);
                            tmp = "";
                        }
                    }
                }
                
                System.out.println();
            }            
        }
    }    
}
