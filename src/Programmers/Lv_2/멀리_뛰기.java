package Programmers.Lv_2;

public class 멀리_뛰기 {

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(2000));
    }

    public static long solution(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
