import java.util.*;

public class Inversion
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int[][] matrix = null;

        System.out.print("Enter 2DArray size -->");
        int size = keyboard.nextInt();
        matrix = new int[size][size];

        System.out.println("---------------------------");
        System.out.println("   Test fillArray");
        System.out.println("---------------------------");
        fillArray(matrix);
        displayArray(matrix);
        System.out.println("---------------------------");
        System.out.println("   Test invertHorizontally");
        System.out.println("---------------------------");
        invertHorizontally(matrix);
        displayArray(matrix);
        System.out.println("---------------------------");
        System.out.println("   Test invertVertically");
        System.out.println("---------------------------");
        invertVertically(matrix);
        displayArray(matrix);
    }
    /* Precondition: array2D.length > 0 && array2D[0].length > 0
     * Postcondition: array2D is populated with random numbers in the
     *                range of 0 to 9 inclusive.
     */
    public static void fillArray(int[][] array2D)
    {

    }

    /* Precondition: array2D.length > 0 && array2D[0].length > 0
     * Postcondition: array2D is displayed on the screen in row/column order
     */
    public static void displayArray(int[][] array2D)
    {

    }
    /* Precondition: array2D.length > 0 && array2D[0].length > 0
     * Postcondition: array2D's columns are inverted
     */
    public static void invertHorizontally(int[][] array2D)
    {

    }

    /* Precondition: array2D.length > 0 && array2D[0].length > 0
     * Postcondition: array2D's rows are inverted
     */
    public static void invertVertically(int[][] array2D)
    {

    }
}