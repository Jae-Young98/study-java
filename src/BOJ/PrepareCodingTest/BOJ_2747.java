package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[46];
        dp[1] = 1;
        for (int i = 2; i <= 45; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}
