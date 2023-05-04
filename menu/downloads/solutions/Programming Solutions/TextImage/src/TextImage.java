import java.util.*;
import java.io.*;

public class TextImage
{
    public static void main(String[] args)
    {
        int[][] image= new int[14][15];
        Scanner keyboard = new Scanner(System.in);
        readFile(image);
        System.out.println("---------------------------");
        System.out.println("   Test displayImage");
        System.out.println("---------------------------");
        displayImage(image);
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("   Test displayUpsideDown");
        System.out.println("---------------------------");
        displayUpsideDown(image);
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("   Test enlarge");
        System.out.println("---------------------------");
        enlarge(image);
    }
    /* Precondition: array2D.length > 0 and array2D[0].length > 0
     * Postcondition: displays a text image on the console window by
     *   traversing array2D in row/column order. Each cell of array2D
     *   contains a number between 1 and 3 inclusive. If a cell contains
     *   a 1 the method displays "@ " on the screen. If a cell contains
     *   a 2 the method displays "+ " on the screen. If a cell contains
     *   a 3 the method displays "  " on the screen.
     */

    public static void displayImage(int[][] array2D)
    {

    }

    /* Precondition: array2D.length > 0 and array2D[0].length > 0
     * Postcondition: displays the text image upside down.
     */
    public static void displayUpsideDown(int[][] array2D)
    {

    }
    /* Precondition: array2D.length > 0 and array2D[0].length > 0
     * Postcondition: displays the text image twice the size of the
     *   original image. This is accomplished by displaying each row
     *   and column twice.
     */
    public static void enlarge(int[][] array2D)
    {

    }

    /*
     * This method reads numbers from a data file and stores
     *   them in array2D.
     */

    public static void readFile(int[][] array2D)
    {
       Scanner infile = null;
       try {
          infile = new Scanner(new File("datafile.txt"));
       }
       catch(IOException ex) {
              System.out.println("File not found");
       }

       for(int r = 0; r < array2D.length; r++)
       {
            for(int c = 0; c < array2D[r].length; c++)
            {
                    array2D[r][c] = infile.nextInt();
            }
       }
    }
}