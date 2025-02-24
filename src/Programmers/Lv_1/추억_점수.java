package Programmers.Lv_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            String people = name[i];
            int score = yearning[i];
            map.put(people, score);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String people = photo[i][j];

                if (map.containsKey(people)) {
                    score += map.get(people);
                }
            }

            answer[i] = score;
        }
        return answer;
    }
}
