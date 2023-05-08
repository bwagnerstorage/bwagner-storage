import java.io.*;
import java.util.*;

public class Friendly {
	
	public static void main(String args[]) throws IOException {
    	Scanner kb = new Scanner(new File("friendly.dat"));
    	
    	while (kb.hasNextLine()) {
    		String line = kb.nextLine().trim();
    		String[] tokens = line.split(" ");
    		
    		String[] timeTokens = tokens[0].split(":");
    		int hour = Integer.parseInt(timeTokens[0]);
    		int min = Integer.parseInt(timeTokens[1]);
    		int sec = Integer.parseInt(timeTokens[2]);
    		
    		System.out.printf("%s:%s:%s ", timeTokens[0], timeTokens[1], timeTokens[2]);
    		
    		String message = "";
    		for (int i = 1; i < tokens.length; ++i) {
    			message = message.concat(tokens[i]);
    			if (i < tokens.length - 1) {
    				message = message.concat(" ");
    			}
    		}
    		
    		byte first = (byte)(hour * 9);
    		byte second = (byte)(min * 3 + sec);
    		int length = message.length();
    		for (int i = 0; i < length; i += 2) {
    			char c1 = (char)(message.charAt(i + 0) ^ first);
    			char c2 = (i == length - 1) ? 0 : (char)(message.charAt(i + 1) ^ second);
      			if (i == length - 1) {
    				System.out.printf("0x%02X ", c1 & 0xFF);
    			}
    			else {
    				System.out.printf("0x%02X 0x%02X ", c1 & 0xFF, c2 & 0xFF);
    			}
    		}
    		
    		System.out.println();
    	}
    }
}
