package Programmers.Lv_2;

public class 숫자의_표현 {

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        int start = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
            while (sum > n) {
                sum -= start;
                start++;
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }
}
