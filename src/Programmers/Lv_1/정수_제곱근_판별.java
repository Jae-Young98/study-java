package Programmers.Lv_1;

public class 정수_제곱근_판별 {

    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(3));
    }

    public static long solution(long n) {
        long answer = -1;

        double sqrt = Math.sqrt(n);

        if (sqrt % 1 == 0) {
            answer = (long) Math.pow(sqrt + 1, 2);
        }

        return answer;
    }
}
