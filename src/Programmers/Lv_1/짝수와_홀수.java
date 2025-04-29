package Programmers.Lv_1;

public class 짝수와_홀수 {

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int num) {
        if (num % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}
