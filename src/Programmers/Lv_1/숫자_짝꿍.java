package Programmers.Lv_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 숫자_짝꿍 {

    public static void main(String[] args) {
        System.out.println(solution("111", "11111"));
    }

    public static String solution(String X, String Y) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            if (map.containsKey(c) && map.get(c) >= 1) {
                list.add(Integer.parseInt(String.valueOf(c)));
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        list.sort(Comparator.reverseOrder());
        if (list.isEmpty()) {
            return "-1";
        }

        if (list.get(0) == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
