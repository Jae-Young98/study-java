package Programmers.Lv_1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder answer = new StringBuilder();
        for (String str : arr) {
            answer.append(str);
        }

        return answer.toString();
    }
}
