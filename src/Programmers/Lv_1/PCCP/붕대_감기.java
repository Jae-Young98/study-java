package Programmers.Lv_1.PCCP;

import java.util.HashMap;
import java.util.Map;

public class 붕대_감기 {

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int maxHealth = health;

        int time = attacks[attacks.length - 1][0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
        }

        int streak = 0;
        for (int i = 0; i <= time; i++) {
            if (map.containsKey(i)) {
                health -= map.get(i);
                streak = 0;

                if (health <= 0) {
                    return -1;
                }
            } else {
                health += x;
                streak++;

                if (streak == t) {
                    health += y;
                    streak = 0;
                }

                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
        }

        return health;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 5}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
    }
}
