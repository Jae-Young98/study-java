package Programmers.Lv_1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int val = choices[i];

            if (val < 4) {
                char c = survey[i].charAt(0);
                map.put(c, map.getOrDefault(c, 0) + 4 - val);
            } else {
                char c = survey[i].charAt(1);
                map.put(c, map.getOrDefault(c, 0) + val - 4);
            }
        }

        if (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) {
            sb.append('R');
        } else {
            sb.append('T');
        }

        if (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) {
            sb.append('C');
        } else {
            sb.append('F');
        }

        if (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) {
            sb.append('J');
        } else {
            sb.append('M');
        }

        if (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) {
            sb.append('A');
        } else {
            sb.append('N');
        }

        return sb.toString();
    }
}
