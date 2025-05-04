package Programmers.Lv_1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{10})));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            }

            answer[idx] = arr[i];
            idx++;
        }

        return answer;
    }
}
