package Programmers.Lv_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 귤_고르기 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int sum = 0;
        int answer = 0;
        for (int size : list) {
            sum += map.get(size);
            answer++;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}
