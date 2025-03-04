package Programmers.Lv_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 메뉴_리뉴얼 {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);

            orders[i] = String.valueOf(ch);
        }

        for (int len : course) {
            for (String order : orders) {
                comb(order, len, "");
            }

            if (!map.isEmpty()) {
                List<Integer> cntList = new ArrayList<>(map.values());
                int max = Collections.max(cntList);

                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answer.add(key);
                        }
                    }
                }
                map.clear();
            }
        }

        Collections.sort(answer);

        return answer.toArray(String[]::new);
    }

    public static void comb(String order, int cnt, String tmp) {
        if (cnt == 0) {
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            comb(order.substring(i + 1), cnt - 1, tmp + order.charAt(i));
        }
    }
}
