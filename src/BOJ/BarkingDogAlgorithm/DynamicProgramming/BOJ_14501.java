package BOJ.BarkingDogAlgorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (t[i] + i <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
