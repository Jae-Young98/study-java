package Programmers.Lv_1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수_내림차순으로_배치하기 {

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        String str = String.valueOf(n);
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }

        return Long.parseLong(sb.toString());
    }
}
