package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();

        int ALength = strA.length();
        int BLength = strB.length();
        int[][] dp = new int[ALength + 1][BLength + 1];
        int max = 0;
        for (int i = 1; i <= ALength; i++) {
            char c = strA.charAt(i - 1);
            for (int j = 1; j <= BLength; j++) {
                if (c == strB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
