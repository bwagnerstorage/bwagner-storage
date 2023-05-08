/*
UIL 2017
State - Rohan

In a recent geometry lesson on triangles and the various aspects they possess, 
Rohan needs help finding two interesting points – the centroid and the incenter. 
He also needs to find the area of any triangle, but he already knows Heron’s formula 
and does not need help with that, which he knows uses the semi-perimeter of the 
triangle in an interesting formula that takes the square root of the product of 
four things: the semi-perimeter itself, and the three differences between the 
semi-perimeter and each of the three sides a, b, and c. He also realizes he needs 
to use the distance formula to find the lengths of the sides a, b and c, 
but already knows that one too.

He decides to look up what those centroid and incenter mean, and discovers that 
an incenter is a point in the middle of any triangle where all three angle bisectors 
meet, and that the centroid is another point in the middle of the triangle where 
all the medians of a triangle meet.  

He finds two really cool formulas for incenter and centroid, not fully comprehending 
how they work, but figures if he can code them correctly, he’ll be OK.  

The centroid X value (Xc) uses a formula that averages the three X coordinates of 
the vertices of the triangle:						Xc = (Xa + Xb + Xc)/3
with the Yc value using a similar formula.

The incenter formula for the Y value (Yi) is a bit more complex:
Yi = (a*Ya + b*Yb + c*Yc) / (a+b+c)
with a similar formula used for Xi.

Input: Several sets of six real number values no farther from zero than a 
distance of 100, representing the X and Y coordinates of three vertices of 
a triangle A, B, and C, in the order Xa, Ya, Xb, Yb, Xc, Yc.

Output: Two sets of coordinates representing the centroid and incenter of a 
triangle, and a third value representing the area, in the format shown below, 
with the two coordinate pairs included inside parentheses, separated by a comma 
with no spaces, and the area as a single real value.  All values are to be 
expressed using rounded precision to the hundredths place.

Sample Input:
-2 4 4 2 0 -6
-2 7 7 4 1 -2
Sample Output:
(0.90,0.72)
(0.67,0.00)
28.00
(2.15,2.85)
(2.00,3.00)
36.00

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Rohan
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("rohan.dat"));
		while(f.hasNext()){
			double Xa = f.nextDouble(), Ya = f.nextDouble(),
				Xb = f.nextDouble(), Yb = f.nextDouble(),
				Xc = f.nextDouble(), Yc = f.nextDouble();
		double a = distance(Xb,Yb,Xc,Yc);	
		double b = distance(Xa,Ya,Xc,Yc);
		double c = distance(Xa,Ya,Xb,Yb);
		double xi  = (a*Xa + b*Xb + c*Xc) / (a+b+c);
		double yi = (a*Ya + b*Yb + c*Yc) / (a+b+c);
		double xc = (Xa+Xb+Xc)/3;
		double yc = (Ya+Yb+Yc)/3;
		double s = (a+b+c)/2;
		double area =Math.sqrt(s*(s-a)*(s-b)*(s-c)); 
		out.printf("(%.2f,%.2f)\n",xi,yi);
		out.printf("(%.2f,%.2f)\n",xc,yc);
		out.printf("%.2f\n",area);
		}
	}
	static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1,2));
	}
}
/*
-2 4 4 2 0 -6
-2 7 7 4 1 -2
-4 0 4 0 0 6.93
0 0 3 0 0 4
0 5 0 -5 5 5
100 100 -100 100 0 -100
 
 (0.90,0.72)
(0.67,0.00)
28.00
(2.15,2.85)
(2.00,3.00)
36.00
(0.00,2.31)
(0.00,2.31)
27.72
(1.00,1.00)
(1.00,1.33)
6.00
(1.91,3.09)
(1.67,1.67)
25.00
(0.00,38.20)
(0.00,33.33)
20000.00


*/