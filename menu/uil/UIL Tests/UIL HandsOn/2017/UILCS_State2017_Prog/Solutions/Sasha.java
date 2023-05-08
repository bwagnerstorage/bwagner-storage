/*
UIL 2017
State - Sasha
*/
import java.io.*;
import java.util.*;

class Sasha {
  public static void main(String [] args) throws FileNotFoundException {
    Scanner f = new Scanner(new File("sasha.dat"));
    int N = f.nextInt();f.nextLine();
    while(N-- > 0) {
      String firstLine = f.nextLine();
      int size1 = firstLine.length();
      char[][] image1 = new char[size1][size1];
      String line = firstLine;
      for(int i = 0; i < size1; i++) {
        for(int j = 0; j < size1; j++) {
          image1[i][j] = line.charAt(j);
        }
        line = f.nextLine();
      }

      String secondLine = f.nextLine();
      int size2 = secondLine.length();
      char[][] image2 = new char[size2][size2];
      line = secondLine;
      for(int i = 0; i < size2; i++) {
        for(int j = 0; j < size2; j++) {
          image2[i][j] = line.charAt(j);
        }
        line = f.nextLine();
      }

      for(int i = 0; i < image1.length; i++) {
        for(int j = 0; j < image1.length; j++) {
      //    System.out.print(image1[i][j]);
        }
      //  System.out.println();
      }
    //  System.out.println();
      for(int i = 0; i < image2.length; i++) {
        for(int j = 0; j < image2.length; j++) {
    //      System.out.print(image2[i][j]);
        }
    //    System.out.println();
      }

      int smallestX1 = 1000;
      int largestX1 = -1;
      int smallestY1 = 1000;
      int largestY1 = -1;
      for(int i = 0; i < image1.length; i++) {
        for(int j = 0; j < image1.length; j++) {
          if(image1[i][j] == '#') {
            smallestX1 = Math.min(i, smallestX1);
            largestX1 = Math.max(i, largestX1);
            smallestY1 = Math.min(j, smallestY1);
            largestY1 = Math.max(j, largestY1);
          }
        }
      }
      int smallestX2 = 1000;
      int largestX2 = -1;
      int smallestY2 = 1000;
      int largestY2 = -1;
      for(int i = 0; i < image2.length; i++) {
        for(int j = 0; j < image2.length; j++) {
          if(image2[i][j] == '#') {
            smallestX2 = Math.min(i, smallestX2);
            largestX2 = Math.max(i, largestX2);
            smallestY2 = Math.min(j, smallestY2);
            largestY2 = Math.max(j, largestY2);
          }
        }
      }

      Shape shape1 = new Shape();
      Shape shape2 = new Shape();

      shape1.x = smallestX1;
      shape1.y = smallestY1;
      shape2.x = smallestX2;
      shape2.y = smallestY2;

      int sizeX1 = largestX1 - smallestX1 + 1;
      int sizeY1 = largestY1 - smallestY1 + 1;
      shape1.image = new char[sizeX1][sizeY1];
      for(int i = 0; i < sizeX1; i++) {
        for(int j = 0; j < sizeY1; j++) {
          shape1.image[i][j] = image1[i + shape1.x][j + shape1.y];
        //  System.out.print(shape1.image[i][j]);
        }
      //  System.out.println();
      }

      int sizeX2 = largestX2 - smallestX2 + 1;
      int sizeY2 = largestY2 - smallestY2 + 1;
      shape2.image = new char[sizeX2][sizeY2];
      for(int i = 0; i < sizeX2; i++) {
        for(int j = 0; j < sizeY2; j++) {
          shape2.image[i][j] = image2[i + shape2.x][j + shape2.y];
    //      System.out.print(shape2.image[i][j]);
        }
    //    System.out.println();
      }

      for(int s = 10; s > 0; s--) {
        boolean isScale = true;
        for(int i = 0; i < shape1.image.length; i+=s) {
          for(int j = 0; j < shape1.image[0].length; j+=s) {
            boolean gridMatch = true;
            char let = shape1.image[i][j];
            for(int q = i; q < i + s; q++) {
              for(int p = j; p < j + s; p++) {
                //System.out.println( "i: " + i + " j: "+ j + " q: " + q + " p: " + p + " s: " + s);
                if(q >= shape1.image.length || p >= shape1.image[0].length || shape1.image[q][p] != let) {
                  gridMatch = false;
                }
              }
            }
            isScale &= gridMatch;
          }
        }

        if(isScale) {
          shape1.scale = s;
          break;
        }
      }

      for(int s = 10; s > 0; s--) {
        boolean isScale = true;
        for(int i = 0; i < shape2.image.length; i+=s) {
          for(int j = 0; j < shape2.image[0].length; j+=s) {
            boolean gridMatch = true;
            char let = shape2.image[i][j];
            for(int q = i; q < i + s; q++) {
              for(int p = j; p < j + s; p++) {
                //System.out.println( "i: " + i + " j: "+ j + " q: " + q + " p: " + p + " s: " + s);
                if(q >= shape2.image.length || p >= shape2.image[0].length || shape2.image[q][p] != let) {
                  gridMatch = false;
                }
              }
            }
            isScale &= gridMatch;
          }
        }

        if(isScale) {
          shape2.scale = s;
          break;
        }
      }

      //System.out.println(shape2.scale);
      shape1.normalized = new char[shape1.image.length/shape1.scale][shape1.image[0].length/shape1.scale];
      for(int i = 0; i < shape1.normalized.length; i++) {
        for(int j = 0; j < shape1.normalized[0].length; j++) {
          shape1.normalized[i][j] = shape1.image[i * shape1.scale ][j * shape1.scale];
        }
      }

      shape2.normalized = new char[shape2.image.length/shape2.scale][shape2.image[0].length/shape2.scale];
      for(int i = 0; i < shape2.normalized.length; i++) {
        for(int j = 0; j < shape2.normalized[0].length; j++) {
          shape2.normalized[i][j] = shape2.image[i * shape2.scale ][j * shape2.scale];
        }
      }

      System.out.println(same(shape1, shape2));
    }
  }

  public static String same(Shape shape1, Shape shape2) {
    if(shape1.normalized.length != shape2.normalized.length || shape1.normalized[0].length != shape2.normalized[0].length) {
      return "DIFFERENT";
    }

    for(int i = 0; i < shape1.normalized.length; i++) {
      for(int j = 0; j < shape1.normalized[0].length; j++) {
        if(shape1.normalized[i][j] != shape2.normalized[i][j]) {
          return "DIFFERENT";
        }
      }
    }

    return "SAME";
  }
}

class Shape {
  int scale;
  int x;
  int y;
  char [][] image;
  char [][] normalized;
}
