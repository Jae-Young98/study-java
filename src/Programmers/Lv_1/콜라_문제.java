package Programmers.Lv_1;

public class 콜라_문제 {

    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= 2 && n >= a) {
            int cola = (n / a) * b;
            n = n % a + cola;

            answer += cola;
        }
        return answer;
    }
}
