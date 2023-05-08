import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Stencil {
	public static void main(String args[]) throws IOException {
		char s[][] = new char [21][25];
		for(int i=0; i<21; i++)
			Arrays.fill(s[i],'*');
		for(int i=1; i<11; i++) {
			s[i][i]=' ';
			s[i][i+1]=' ';
		}
		for(int i=10; i<20; i++) {
			s[i][i+3]=' ';
			s[i][i+4]=' ';
		}
		for(int i=1; i<11; i++) {
			s[i][25-i-1]=' ';
			s[i][25-i-2]=' ';
		}
		for(int i=10; i<20; i++) {
			s[i][25-i-4]=' ';
			s[i][25-i-5]=' ';
		}
		for(int i=0; i<21; i++) {
			for(int j=0; j<25; j++)
				out.print(s[i][j]);
			out.println();
		}			
	}	
}
