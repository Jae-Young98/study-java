package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        dp[1] = cards[1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 1개 살 때의 최솟값 ... n개 살 때의 최솟값
                dp[i] = Math.min(dp[i], dp[i - j] + cards[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
