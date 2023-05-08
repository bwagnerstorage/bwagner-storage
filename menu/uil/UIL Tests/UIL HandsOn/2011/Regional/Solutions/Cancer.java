import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cancer
{
    public static final char kCellCancer = '#';
    public static final char kCellNeedle = '@';
    public static final char kCellHealthy = '.';
    
    public static final int kMaxStack = 25;
    
    public static int iCurrentMaxStep = 0;
    
    
    public static void PrintCancer(char[][] cancer)
    {
        for (int y = 0; y < cancer.length; ++y)
        {
            for (int x = 0; x < cancer[0].length; ++x)
            {
                System.out.print(cancer[y][x]);
            }
            
            System.out.println();
        }
    }
    
    public static char[][] CancerSimulationCopy(char[][] cancerSource)
    {
        int s = cancerSource.length;
        char[][] cancerCopy = new char[s][s];
        for (int x = 0; x < s; ++x)
        {
            for (int y = 0; y < s; ++y)
            {
                cancerCopy[x][y] = cancerSource[x][y];
            }
        }
        
        return cancerCopy;
    }
    
    public static boolean IsInfectedSafe(char[][] cancer, int x, int y)
    {
        int size = cancer.length;
        if (0 > x || size <= x)
            return false;
        
        if (0 > y || size <= y)
            return false;
        
        char ch = cancer[x][y];
        return kCellNeedle == ch || kCellCancer == ch;
    }
    
    public static boolean ShouldRemainCancer(char[][] cancer, int x, int y)
    {
        boolean[] bInfected = new boolean[8];
        
        bInfected[0] = IsInfectedSafe(cancer, x - 1, y - 1);
        bInfected[1] = IsInfectedSafe(cancer, x - 1, y + 0);
        bInfected[2] = IsInfectedSafe(cancer, x - 1, y + 1);
        
        bInfected[3] = IsInfectedSafe(cancer, x + 0, y - 1);
        bInfected[4] = IsInfectedSafe(cancer, x + 0, y + 1);
        
        bInfected[5] = IsInfectedSafe(cancer, x + 1, y - 1);
        bInfected[6] = IsInfectedSafe(cancer, x + 1, y + 0);
        bInfected[7] = IsInfectedSafe(cancer, x + 1, y + 1);
        
        int infections = 0;
        for (int i = 0; i < 8; ++i)
        {
            if (bInfected[i])
                infections++;
        }
        
        return 2 == infections || 3 == infections;
    }
    
    public static boolean ShouldBecomeCancer(char[][] cancer, int x, int y)
    {
        boolean[] bInfected = new boolean[8];
        
        bInfected[0] = IsInfectedSafe(cancer, x - 1, y - 1);
        bInfected[1] = IsInfectedSafe(cancer, x - 1, y + 0);
        bInfected[2] = IsInfectedSafe(cancer, x - 1, y + 1);
        
        bInfected[3] = IsInfectedSafe(cancer, x + 0, y - 1);
        bInfected[4] = IsInfectedSafe(cancer, x + 0, y + 1);
        
        bInfected[5] = IsInfectedSafe(cancer, x + 1, y - 1);
        bInfected[6] = IsInfectedSafe(cancer, x + 1, y + 0);
        bInfected[7] = IsInfectedSafe(cancer, x + 1, y + 1);
        
        int infections = 0;
        for (int i = 0; i < 8; ++i)
        {
            if (bInfected[i])
                infections++;
        }
        
        return 3 == infections;
    }
    
    public static int StepTime(char[][] cancer, int needleX, int needleY, int moveNeedleX, int moveNeedleY, boolean bAnythingDoneLastTime, int n)
    {
        if (n > iCurrentMaxStep)
            return -1;
        
        int size = cancer.length;
        if (0 > needleX || size <= needleX)
            return -1;
        
        if (0 > needleY || size <= needleY)
            return -1;
        
        if (0 > moveNeedleX || size <= moveNeedleX)
            return -1;
        
        if (0 > moveNeedleY || size <= moveNeedleY)
            return -1;
        
        if (kCellCancer == cancer[moveNeedleX][moveNeedleY])
            return -1;
        
        cancer[needleX][needleY] = kCellHealthy;
        cancer[moveNeedleX][moveNeedleY] = kCellNeedle;
        
        // Modify time step until nothing spreads
        boolean bHasCancer = false;
        boolean bWasAnythingDone = false;

        // go through every entry in array and place it into a new array
        // so that we don't spread multiple ticks at once
        char[][] newCancer = new char[size][size];
        for (int x = 0; x < size; ++x)
        {
            for (int y = 0; y < size; ++y)
            {
                char ch = cancer[x][y];
                newCancer[x][y] = ch;
                
                // Don't modify needle cell
                if (kCellCancer == ch)
                {
                    if (!ShouldRemainCancer(cancer, x, y))
                    {
                        newCancer[x][y] = kCellHealthy;
                        
                        bWasAnythingDone = true;
                    }
                    else
                    {
                        bHasCancer = true;
                    }
                }
                else if (kCellHealthy == ch)
                {
                    if (ShouldBecomeCancer(cancer, x, y))
                    {
                        bHasCancer = true;
                        newCancer[x][y] = kCellCancer;
                        
                        bWasAnythingDone = true;
                    }
                }
            }
        }
        
        if (!bHasCancer)
        {
            // Free of cancer?  Done!
            return 1;
        }
        else if (!bWasAnythingDone && !bAnythingDoneLastTime)
        {
            // Can't do anything anymore and still has cancer, fail!
            return -1;
        }
        else
        {
            // More cancer, need to step time
            int lowest = MoveAndReturnLowest(newCancer, moveNeedleX, moveNeedleY, bWasAnythingDone, n);
            if (0 <= lowest)
            {
                return 1 + lowest;
            }
            else
            {
                return -1;
            }
        }
    }
    
    public static int MoveAndReturnLowest(char[][] cancer, int needleX, int needleY, boolean bAnythingDoneLastTime, int n)
    {
        // Find the least amount of moves
        char[][] cancerCopy = CancerSimulationCopy(cancer);
        
        int[] results = new int[8];
        
        results[0] = StepTime(cancerCopy, needleX, needleY, needleX - 1, needleY - 1, bAnythingDoneLastTime, n + 1);
        cancerCopy = CancerSimulationCopy(cancer);
        results[1] = StepTime(cancerCopy, needleX, needleY, needleX - 1, needleY + 0, bAnythingDoneLastTime, n + 1);
        cancerCopy = CancerSimulationCopy(cancer);
        results[2] = StepTime(cancerCopy, needleX, needleY, needleX - 1, needleY + 1, bAnythingDoneLastTime, n + 1);
        
        cancerCopy = CancerSimulationCopy(cancer);
        results[3] = StepTime(cancerCopy, needleX, needleY, needleX + 0, needleY - 1, bAnythingDoneLastTime, n + 1);
        cancerCopy = CancerSimulationCopy(cancer);
        results[4] = StepTime(cancerCopy, needleX, needleY, needleX + 0, needleY + 1, bAnythingDoneLastTime, n + 1);
        
        cancerCopy = CancerSimulationCopy(cancer);
        results[5] = StepTime(cancerCopy, needleX, needleY, needleX + 1, needleY - 1, bAnythingDoneLastTime, n + 1);
        cancerCopy = CancerSimulationCopy(cancer);
        results[6] = StepTime(cancerCopy, needleX, needleY, needleX + 1, needleY + 0, bAnythingDoneLastTime, n + 1);
        cancerCopy = CancerSimulationCopy(cancer);
        results[7] = StepTime(cancerCopy, needleX, needleY, needleX + 1, needleY + 1, bAnythingDoneLastTime, n + 1);
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 8; ++i)
        {
            if (0 < results[i])
                al.add(results[i]);
        }
        
        if (0 == al.size())
        {
            return -1;
        }
        else
        {
            int solution = (int)al.get(0);
            
            for (int i = 1; i < al.size(); ++i)
            {
                int val = (int)al.get(i);
                solution = (val < solution) ? val : solution;
            }
            
            return solution;
        }
    }
        
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("cancer.dat"));
        
        int simulations = Integer.parseInt(kb.nextLine());
        
        // For each simulation
        for (int s = 0; s < simulations; ++s)
        {
            int size = Integer.parseInt(kb.nextLine());
            
            int startX = -1;
            int startY = -1;
            boolean bHasCancer = false;
            
            // For each line in simulation
            char[][] cancer = new char[size][size];
            for (int l = 0; l < size; ++l)
            {
                // For each character in line
                String line = kb.nextLine();
                for (int c = 0; c < size; ++c)
                {
                    cancer[l][c] = line.charAt(c);
                    
                    if ('@' == cancer[l][c])
                    {
                        startX = l;
                        startY = c;
                    }
                    else if ('#' == cancer[l][c])
                    {
                        bHasCancer = true;
                    }
                }
            }
            
            // No cancer, then we are done!
            if (!bHasCancer)
            {
                System.out.println("0");
                continue;
            }
            
            // If not, lets run the simulation with an increasing cap, until the max is hit
            boolean bFound = false;
            for (int i = 0; i < kMaxStack; ++i)
            {
                iCurrentMaxStep = i + 1;
                
                int lowest = MoveAndReturnLowest(cancer, startX, startY, true, 0);
                if (0 < lowest)
                {
                    System.out.println(lowest);
                    bFound = true;
                    break;
                }
            }
            
            if (!bFound)
                System.out.println("-1");
        }
    }
}
