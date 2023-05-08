//2019 UIL B Packet - Solution
//Hyun
import java.io.*;
import java.util.*;

public class Hyun {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("hyun.dat"));
        int T = Integer.parseInt(scan.nextLine());
        String[] rowNames = {"NUMBER", "TOP", "HOME", "BOTTOM"};
        String[] keys = {"1234567890", "qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int caseNum = 1; caseNum <= T; ++caseNum) {
            String s = scan.nextLine();
            boolean[] used = new boolean[4];
            for (char c : s.toCharArray()) {
                for (int i = 0; i < 4; i++) {
                    if (keys[i].indexOf(c) >= 0) {
                        used[i] = true;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (used[i]) {
                    sb.append(' ');
                    sb.append(rowNames[i]);
                }
            }

            System.out.printf("Case #%d:%s%n", caseNum, sb.toString());
        }
    }
}
