package Programmers.Lv_1;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];

        for (int i = str.length() - 1; i >= 0; i--) {
            answer[(str.length() - 1) - i] = str.charAt(i) - '0';
        }

        return answer;
    }
}
