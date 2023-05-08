// UIL 2006 - Regional Programming Contest
//
// look.java
//
// The purpose of this problem is to test contestant
// ability to perform non-trivial mathematical manipulations.
//
// Note: This is, by far, the hardest regional problem in
// this year's set.  It is doable, but should certainly be
// done last.  Fortunately, the trickiest component is
// figuring out the formulas needed.  If a team can have
// one member doing all the calculations for this problem
// while other solutions are being coded, this problem
// could be done in a contest setting.
//
// However, there are also quite a large number of
// special cases, so there is not only a large debugging
// period necessary for solving this problem, but as
// long as the master data is thorough, it is likely that
// the master data will test boundary conditions that
// were not thought of by the solution writer.
//

import java.io.*;
import java.util.*;

public class look {
   
   public static void main (String args[]) throws IOException {

      Scanner infile = new Scanner( new File("look.in") );

      int numDataSets = infile.nextInt();
      infile.nextLine();

      for (int i=0; i<numDataSets; i++) {
         double lx      = infile.nextDouble();
         double ly      = infile.nextDouble();
         double radius  = infile.nextDouble();
         double bx      = infile.nextDouble();
         double by      = infile.nextDouble();
         double hdeg    = infile.nextDouble();  // heading in degrees
         double hrad    = Math.toRadians(hdeg); // heading in radians
         infile.nextLine();

         // formula for a circle is (x-lx)^2 + (y-ly)^2 = r^2
         //    luckily, we already know lx, ly, and r
         // formula for a line is y = mx + b
         //    we need to calculate m and b
         //    m is easiest, since slope is the tangent of the angle
         //    however, tangent is undefined at 90 * 270 degrees

         if (hdeg == 90 || hdeg == 270) {
            // the formula for the boat's line is x = bx
            // we will never hit shore
            // (bx-lx)^2 + (y-ly)^2 = r^2
            // (y-ly)^2 = r^2 - (bx-lx)^2
            // y-ly = +/- sqrt(r^2 - (bx-lx)^2)
            // y = +/- sqrt(r^2 - (bx-lx)^2) + ly
            double desc = Math.pow(radius,2.0) - Math.pow(bx-lx,2.0);
            if (desc < 0) {    // imaginary, never see the lighthouse
               System.out.println("Lost at sea");
            }
            else {
               double y1 = Math.sqrt(desc) + ly;
               double y2 = -Math.sqrt(desc) + ly;
               if (  (hdeg == 90  && ((y1 >= by) || (y2 >= by))) 
                     ||
                     (hdeg == 270 && ((y1 <= by) || (y2 <= by))) ) {
                  System.out.println("Saved by the lighthouse");
               }
               else {
                  System.out.println("Lost at sea");
               }
            }
         }
         else {
            double m = Math.tan(hrad);
            double b = by - (m * bx);
            // Ok, so we know all of y = mx + b
            // now, substitute mx + b for y in the circle forumla:
            //    (x-lx)^2 + (mx+b-ly)^2 = r^2
            //    x^2 - 2xlx + lx^2 + m^2x^2 + 2mx(b-ly) + (b-ly)^2 = r^2
            //    (m^2 + 1)x^2 + (2lx + 2m(b-ly))x + (lx^2 + (b-ly)^2 - r^2) = 0
            // now use the quadratic formula to solve:
            //    Ax^2 + Bx + C = 0
            //    x = (-B +/-SQRT(B^2 - 4AC)) / 2A
            //    descrimiate = (B^2 - 4AC)
            double A = Math.pow(m,2.0) + 1;
            double B = (2 * m * (b - ly)) - (2 * lx);
            double C = 
               Math.pow(lx,2.0) + Math.pow(b-ly,2.0) - Math.pow(radius, 2.0);
            double desc = Math.pow(B,2.0) - (4 * A * C);
            if (desc < 0) {
               // solutions are imaginary, the boat never sees the light
               // we know he'll hit shore if 90 < heading < 270
               if ( (90 < hdeg) && (hdeg < 270) ) {
                  System.out.println("Look out!");
               } 
               else {
                  System.out.println("Lost at sea");
               }
            }
            else {
               // the boat might see the light, as long as he's headed
               // toward it instead of away.
               // we have to finish calculating the intersection points
               double x1 = (-B + Math.sqrt(desc)) / (2*A);
               double x2 = (-B - Math.sqrt(desc)) / (2*A);
               double y1 = m*x1 + b;
               double y2 = m*x2 + b;

               // now figure out if (x1,y1) or (x2,y2) is in front of the boat
               if (hdeg > 90 && hdeg < 270) { // going west
                  if ((x1 > 0 && x1 < bx) ||  // cross before hit land
                      (x2 > 0 && x2 < bx) ||  // cross before hit land
                      (x1 < bx && x2 > bx) || // already in the light
                      (x1 > bx && x2 < bx)) { // already in the light
                     System.out.println("Saved by the lighthouse");
                  }
                  else {
                     System.out.println("Look out!");
                  }
               }
               else { // going east
                  if ((x1 > bx) ||            // see light eventually
                      (x2 > bx) ||            // see light eventually
                      (x1 < bx && x2 > bx) || // already in the light
                      (x1 > bx && x2 < bx)) { // already in the light
                     System.out.println("Saved by the lighthouse");
                  }
                  else {
                     System.out.println("Lost at sea");
                  }
               }
            }
         }
      }
   }
}
