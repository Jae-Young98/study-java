package Programmers.kit.Hash;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        int pick = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int result = map.size();
        if (result > pick) {
            result = pick;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 1, 2, 3}));
        System.out.println(solution(new int[] {3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[] {3, 3, 3, 2, 2, 2}));
    }

}
