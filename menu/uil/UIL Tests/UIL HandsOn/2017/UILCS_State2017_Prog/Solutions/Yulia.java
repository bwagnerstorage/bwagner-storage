/*
UIL 2017
State - Yulia
*/
import java.io.*;
import java.util.*;

class Yulia {
  public static void main(String [] args) throws FileNotFoundException {
    Scanner f = new Scanner(new File("yulia.dat"));
    int N = f.nextInt();f.nextLine();
    while(N-- > 0) {
      int l = f.nextInt();f.nextLine();
      char[][] struct = new char[l][l];
      for(int i = 0; i < l; i ++) {
        String s = f.nextLine().toLowerCase();
        for(int j = 0; j < l; j ++) {
          struct[i][j] = s.charAt(j);
        }
      }
      String word = f.nextLine().toLowerCase();
      char[] lets = word.toCharArray();
      int max = 0;
      for(int i = 0; i < l; i ++) {
        char[] a = struct[i];
        max = Math.max(max, lcs(a, lets, l, lets.length));
        for(int j = 0 ; j < l; j++) {
          char[] b = new char[l];
          for(int k = 0; k < l; k++) {
            b[k] = struct[k][j];
          }
          /*for(int q = 0; q < l; q++) {
            System.out.print(a[q]);
          }
          System.out.println();
          for(int q = 0; q < l; q++) {
            System.out.print(b[q]);
          }
          System.out.println();*/
          max = Math.max(max, lcs(b, lets, l, lets.length));
        }
      }
      System.out.println(max);
    }
  }

  public static int lcs(char[] X, char[] Y, int m, int n) {
    if (m == 0 || n == 0) {
       return 0;
    }
    if (X[m - 1] == Y[n-1]) {
       return 1 + lcs(X, Y, m-1, n-1);
    }
    else {
       return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }
  }


}
