// UIL 2006 - State Programming Contest
//
// hello.java
//
// PURPOSE: Shows that teams can read input.
//

import java.io.*;
import java.util.*;


public class hello {
   
   public static final int ASCII_a = 97;

   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("hello.in") );

      System.out.println("Hello " + infile.next() + "!");

   }
}
