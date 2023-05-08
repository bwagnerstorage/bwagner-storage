import java.io.*;

public class matrix {

   public static void main(String args[]) {
      int total_matrices;
      int matrix[][] = new int[10][];
      UILFileReader input = new UILFileReader("matrix.dat");

      for (int i=0; i<10; i++) {
          matrix[i] = new int[10];
      }

      /* Read the total number of matrices */
      total_matrices = input.readInt();

      /* Process that many matrices */
      for (int dataset=0; dataset<total_matrices; dataset++) {
         int size, sum = 0, temp_sum, temp_sum2;
         boolean magic;
         boolean number_used[] = new boolean[101];

         /* Read in this matrix's size */
         size = input.readInt();

         /* Read in the matrix */
         for (int row=0; row<size; row++) {
            for (int col=0; col<size; col++) {
               matrix[row][col]=input.readInt();
            }
         }

         /* Assume it's a magic square until we get a contradiction */
         magic = true;

         /* Check the rows */
         for (int row=0; row<size; row++) {
            temp_sum = 0;
            for (int col=0; col<size; col++) {
               temp_sum+=matrix[row][col];
            }
            if (row == 0) sum = temp_sum;
            else if (temp_sum != sum) magic = false;
         }

         /* Check the columns */
         for (int col=0; col<size; col++) {
            temp_sum=0;
            for (int row=0; row<size; row++) {
               temp_sum+=matrix[row][col];
            }
            if (temp_sum != sum) magic = false;
         }

         /* Check the diagonals */
         temp_sum = temp_sum2 = 0;
         for (int row=0; row<size; row++) {
            temp_sum += matrix[row][row];
            temp_sum2 += matrix[row][(size-1)-row];
         }
         if (temp_sum != sum || temp_sum2 != sum) magic = false;

         /* Check that the numbers from 1 to n were used exactly once */
         for (int i=1; i<=(size*size); i++) {
            number_used[i] = false;
         }
         for (int row=0; row<size; row++) {
            for (int col=0; col<size; col++) {
               if (matrix[row][col] < 0 ||
                   matrix[row][col] > (size*size)) {
                  magic = false;
               }
               else {
                  number_used[matrix[row][col]] = true;
               }
            }
         }
         for (int i=1; i<=(size*size); i++) {
            if (!number_used[i]) magic = false;
         }

         /* Display the results */
         if (!magic) {
            System.out.println("This isn't a magic square.");
         }
         else {
            System.out.println("This magic square has sum = " + sum + ".");
         }
      }
   }
}
