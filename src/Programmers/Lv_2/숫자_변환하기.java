package Programmers.Lv_2;

import java.util.Arrays;

public class 숫자_변환하기 {

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }

    public static int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        if (dp[y] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[y];
    }
}
