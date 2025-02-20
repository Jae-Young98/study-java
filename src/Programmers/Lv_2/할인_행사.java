package Programmers.Lv_2;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana", "chicken", "apple"};
        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = i; j < i + 10; j++) {
                String dis = discount[j];

                if (copy.containsKey(dis)) {
                    copy.put(dis, copy.get(dis) - 1);
                }

                if (copy.containsKey(dis) && copy.get(dis) == 0) {
                    copy.remove(dis);
                }
            }

            if (copy.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
