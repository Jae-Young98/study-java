package Programmers.Lv_1;

public class 약수의_합 {

    public static int solution(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }
}
