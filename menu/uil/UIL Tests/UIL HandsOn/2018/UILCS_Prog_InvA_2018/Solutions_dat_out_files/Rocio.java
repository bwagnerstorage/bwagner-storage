/*2018 UIL Invitational A - Rocio
*/
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Rocio
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("rocio.dat"));
		String s = "============================================";
		while(f.hasNext())
		{
		
			int a = f.nextInt();
			int b = f.nextInt();
//			out.println(a+" "+b);
			for(int r=0;r<a;r++){
				for(int c=0;c<a;c++)
					if((r==c||r==a-c-1)||r>=b&&r<=a-b-1&&c>=b&&c<=a-b-1)
						out.print("*");
					else out.print(" ");
				out.println();
			}
			out.println(s.substring(0,a));
		}
	}
}

/*Judges data
7 2
10 3
9 1
11 3
12 4
10 3
30 12
3 1
6 2
10 4

Judges output:
*     *
 *   *
  ***
  ***
  ***
 *   *
*     *
=======
*        *
 *      *
  *    *
   ****
   ****
   ****
   ****
  *    *
 *      *
*        *
==========
*       *
 *******
 *******
 *******
 *******
 *******
 *******
 *******
*       *
=========
*         *
 *       *
  *     *
   *****
   *****
   *****
   *****
   *****
  *     *
 *       *
*         *
===========
*          *
 *        *
  *      *
   *    *
    ****
    ****
    ****
    ****
   *    *
  *      *
 *        *
*          *
============
*        *
 *      *
  *    *
   ****
   ****
   ****
   ****
  *    *
 *      *
*        *
==========
*                            *
 *                          *
  *                        *
   *                      *
    *                    *
     *                  *
      *                *
       *              *
        *            *
         *          *
          *        *
           *      *
            ******
            ******
            ******
            ******
            ******
            ******
           *      *
          *        *
         *          *
        *            *
       *              *
      *                *
     *                  *
    *                    *
   *                      *
  *                        *
 *                          *
*                            *
==============================
* *
 *
* *
===
*    *
 *  *
  **
  **
 *  *
*    *
======
*        *
 *      *
  *    *
   *  *
    **
    **
   *  *
  *    *
 *      *
*        *
==========
*/
