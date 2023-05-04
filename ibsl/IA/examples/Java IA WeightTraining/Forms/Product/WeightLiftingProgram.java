package org.bwagner;

import java.util.*;

/*
   This class provides static methods for calculating weekly workout weights for 
   each of the four main exercises: bench, squat, incline, and power clean.
   A workout weight is calculated by multipling the max for that exercise
   by the weight percentage determined by the workout week(1 - 10). Each week
   the weight percentage increases by 5%. Weights are rounded to multiples of 5.
*/

public class WeightLiftingProgram
{
    public static double[] formulas = {0.60, 0.65, 0.70, 0.75, 0.80,
                                       0.80, 0.85, 0.90, 0.95, 1.0};
    

    public static int calculateBench(int b, int w)
    {
        double percent = formulas[w - 1];
        double repWeight = b * percent;

        return 5*((int)Math.round(repWeight/5)); //rounds to nearest multiple of 5
    }

    public static int calculateSquat(int s, int w)
    {
        double percent = formulas[w - 1];
        double repWeight = s * percent;

        return 5*((int)Math.round(repWeight/5));
    }

    public static int calculateIncline(int i, int w)
    {
        double percent = formulas[w - 1];
        double repWeight = i * percent;

        return 5*((int)Math.round(repWeight/5));
    }

    public static int calculatePowerClean(int pc, int w)
    {
        double percent = formulas[w - 1];
        double repWeight = pc * percent;

        return 5*((int)Math.round(repWeight/5));
    }

}