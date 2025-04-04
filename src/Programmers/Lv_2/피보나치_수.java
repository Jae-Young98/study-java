package Programmers.Lv_2;

public class 피보나치_수 {

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(10000));
    }

    public static int solution(int n) {
        int[] dp = new int[100001];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= 100000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }
}
