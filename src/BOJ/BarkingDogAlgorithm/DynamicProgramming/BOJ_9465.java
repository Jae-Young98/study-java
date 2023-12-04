package BOJ.BarkingDogAlgorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] arr;
        int[][] dp;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            dp = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int k = 2; k <= n; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + arr[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + arr[1][k];
            }

            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }
        System.out.print(sb);
    }
}
