package Programmers.Lv_2;

import java.util.HashMap;

public class 의상 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (String key : map.keySet()) {
            // 안입는 경우도 있기 때문에 1을 더한다.
            answer *= (map.get(key) + 1);
        }

        answer -= 1;
        return answer;
    }
}
