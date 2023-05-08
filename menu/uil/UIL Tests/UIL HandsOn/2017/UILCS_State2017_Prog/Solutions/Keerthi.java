/*
UIL 2017
State - Keerthi
*/
import java.io.*;
import java.util.*;

class Keerthi{
  public static void main(String [] args) throws FileNotFoundException {
    Scanner f = new Scanner(new File("keerthi.dat"));
    int N = f.nextInt(); f.nextLine();
    while(N-- > 0) {
      islands = new HashMap<>();
      char [][] struct = new char[10][10];
      int [][] internal = new int[10][10];
      for(int r = 0 ; r < 10; r++) {
        String s = f.nextLine();
        for(int c = 0; c < 10; c++) {
    //      System.out.println(s);
          struct[r][c] = s.charAt(c);
          internal[r][c] = 1000;
        }
      }
      int count = 1;
      for(int r = 0; r < 10; r++) {
        for(int c = 0; c < 10; c++) {
          if(struct[r][c] == '#' && internal[r][c] >= 1000) {
            mapIsland(r, c, struct, internal, count);
            count++;
          }
        }
      }
      //System.out.println(islands);

      int countIslands = 0;
      for(int land: islands.keySet()) {
        if(islands.get(land) == 'I') {
          countIslands ++;
        }
      }
      System.out.println(countIslands);
      if(f.hasNextLine()) {
        f.nextLine();
      }
    }
  }
  public static HashMap<Integer,Character> islands = new HashMap<>();
  public static void mapIsland(int r, int c, char[][] struct, int [][] internal, int count) {
    if(r < 0 || r >=10 || c < 0 || c >= 10) {
      islands.put(count, 'E');
      return;
    }

    if(struct[r][c] != '#' || internal[r][c] != 1000) {
      return;
    }

    internal[r][c] = count;
    mapIsland(r-1, c, struct, internal, count);
    mapIsland(r+1, c, struct, internal, count);
    mapIsland(r, c-1, struct, internal, count);
    mapIsland(r, c+1, struct, internal, count);

    if(islands.get(count) == null) {
      islands.put(count, 'I');
    }
  }
}
