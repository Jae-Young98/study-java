package Programmers.Lv_1;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(2, 5)));
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int a = Math.max(n, m);
        int b = Math.min(n, m);

        int gcd = getGcd(a, b);
        int lcm = (a * b) / gcd;

        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }

    public static int getGcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        return getGcd(num2, num1 % num2);
    }
}
