package Programmers.Lv_2;

import java.util.Arrays;

public class n제곱_배열_자르기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2L, 5L)));
        System.out.println(Arrays.toString(solution(4, 7L, 14L)));
        System.out.println(Arrays.toString(solution(10000000, 888_888_888_888L, 888_888_888_900L)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            int col = (int) ((i + left) / n);
            int row = (int) ((i + left) % n);

            answer[i] = Math.max(col, row) + 1;
        }

        return answer;
    }
}
