//2019 UIL B Packet - Solution
//Nisha
import java.io.*;
import java.util.*;

public class Nisha {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("nisha.dat"));
        int T = scan.nextInt();
        long[] ans = new long[51];
        long p = 1;
        for (int i = 1; i <= 50; ++i) {
            ans[i] = 2L * ans[i - 1] + p;
            p <<= 1L;
        }

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scan.nextInt();
            System.out.printf("Case #%d: %d%n", caseNum, ans[n] + 1);
        }
    }
}
