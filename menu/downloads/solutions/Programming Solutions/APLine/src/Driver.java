public class Driver
{
    public static void main(String[] args)
    {
        APLine line1 = new APLine(5, 4, -17);
        double slope1 = line1.getSlope(); // slope1 is assigned -1.25
        boolean onLine1 = line1.isOnLine(5, -2); // true because 5(5) + 4(-2) + (-17) = 0

        System.out.println("Line 1 : 5x + 4y - 17 = 0");
        System.out.println("Slope = " + slope1);
        System.out.println("Point (5, -2) on line : " + onLine1);
        System.out.println();

        APLine line2 = new APLine(-25, 40, 30);
        double slope2 = line2.getSlope(); // slope2 is assigned 0.625
        boolean onLine2 = line2.isOnLine(5, -2); // false because -25(5) + 40(-2) + 30 != 0

        System.out.println("Line 2 : -25x + 40y + 30 = 0");
        System.out.println("Slope = " + slope2);
        System.out.println("Point (5, -2) on line : " + onLine2);
        System.out.println();
    }
}