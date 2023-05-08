import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TreeCompression {
    
    public static class Node implements Comparable<Node> {
        public char ch;
        public int count;
        
        public int compareTo(Node n)
        {
            if (n.count > count) {
                return 1;
            }
            else if (n.count < count) {
                return -1;
            }
            else {
                if (n.ch > ch) {
                    return -1;
                }
                else if (n.ch < ch) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
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
        Scanner kb = new Scanner(new File("treecompression.dat"));
        
        while (kb.hasNext()) {
            String line = kb.nextLine().trim();
            char[] chars = line.toCharArray();
            
            ArrayList<Node> arr = new ArrayList<Node>();

            for (int c = 0; c < chars.length; ++c) {
                Node n = null;
                for (int a = 0; a < arr.size(); ++a) {
                    if (arr.get(a).ch == chars[c]) {
                        n = arr.get(a);
                    }
                }
                
                if (n == null) {
                    n = new Node();
                    n.ch = chars[c];
                    
                    arr.add(n);
                }
                
                ++n.count;
            }
            
            Collections.sort(arr);
            
            String binary = byteToBinary((byte) arr.size());
            
            for (int c = 0; c < arr.size(); ++c) {
                binary += byteToBinary((byte) arr.get(c).ch);
            }
            
            for (int c = 0; c < chars.length; ++c) {
                char ch = chars[c];
                
                for (int a = 0; a < arr.size(); ++a) {
                    Node n = arr.get(a);
                    if (n.ch == ch) {
                        if (arr.size() == 1) {
                            binary += "1";
                        }
                        else {
                            for (int o = 0; o < a; ++o) {
                                binary += "1";
                            }
                            
                            if (a != (arr.size() - 1)) {
                                binary += "0";
                            }
                        }
                    }
                }
            }
            
            String uncompressed = byteToBinary((byte) 0);
            for (int c = 0; c < chars.length; ++c) {
                uncompressed += byteToBinary((byte) chars[c]);
            }
            
            if (binary.length() < uncompressed.length())
            {
                int i = 0;
                for (; i < (1 + arr.size()); ++i) {
                    System.out.println(binary.substring(i * 8, i * 8 + 8));
                }
                
                System.out.println(binary.substring(i * 8));
                System.out.println();
            }
            else
            {
                System.out.println(byteToBinary((byte) 0));
                for (int c = 0; c < chars.length; ++c) {
                    System.out.println(byteToBinary((byte) chars[c]));
                }
                
                System.out.println();
            }
        }
    }    
}
