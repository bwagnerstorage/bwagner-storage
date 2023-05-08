//2019 UIL B Packet - Solution
//Mary
import java.io.*;
import java.util.*;

public class Mary{
    public static void solveCase(Scanner scan) throws IOException {
        int n = scan.nextInt();
        String[] wheels = new String[n];
        for (int i = 0; i < n; i++) {
            wheels[i] = scan.next();
        }

        // changeCost[i][j] = min cost to change wheel i to char j
        int[][] changeCost = new int[n][26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(changeCost[i], Integer.MAX_VALUE);
            int len = wheels[i].length();
            for (int j = 0; j < len; j++) {
                int idx = wheels[i].charAt(j) - 'A';
                changeCost[i][idx] = Math.min(changeCost[i][idx], Math.min(j, len - j));
            }
        }

        char[] result = new char[n];
        int cost = 0;

        // Only need to consider pairs of wheels
        for (int start = 0, end = n - 1; start < end; ++start, --end) {
            int matchCost = Integer.MAX_VALUE;
            char matchChar = ' ';
            for (int j = 0; j < 26; ++j) {
                if (changeCost[start][j] == Integer.MAX_VALUE || changeCost[end][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int curCost = changeCost[start][j] + changeCost[end][j];
                if (curCost < matchCost) {
                    matchCost = curCost;
                    matchChar = (char)(j + 'A');
                }
            }

            if (matchCost == Integer.MAX_VALUE) {
                cost = -1;
                break;
            } else {
                result[start] = matchChar;
                result[end] = matchChar;
                cost += matchCost;
            }
        }

        // Don't forget to set the middle for odd lengths
        if (n % 2 == 1) {
            result[n / 2] = wheels[n / 2].charAt(0);
        }

        if (cost == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.printf("%s %d%n", new String(result), cost);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("mary.dat"));
        int T = scan.nextInt();

        while (T-- > 0) {
            solveCase(scan);
        }
    }
}
