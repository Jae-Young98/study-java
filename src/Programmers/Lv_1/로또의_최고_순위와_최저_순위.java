package Programmers.Lv_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 로또의_최고_순위와_최저_순위 {

    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] winNums1 = {31, 10, 45, 1, 6, 19};
        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] winNums2 = {38, 19, 20, 40, 15, 25};
        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] winNums3 = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(solution(lottos1, winNums1)));
        System.out.println(Arrays.toString(solution(lottos2, winNums2)));
        System.out.println(Arrays.toString(solution(lottos3, winNums3)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 6; i >= 0; i--) {
            if (i < 2) {
                rankMap.put(i, 6);
                continue;
            }
            rankMap.put(i, 7 - i);
        }

        Set<Integer> set = new HashSet<>();
        for (int num : win_nums) {
            set.add(num);
        }

        int correct = 0;
        int zero = 0;
        for (int num : lottos) {
            if (set.contains(num)) {
                correct++;
            }

            if (num == 0) {
                zero++;
            }
        }

        int topRank;
        if (correct + zero > 6) {
            topRank = 1;
        } else {
            topRank = rankMap.get(correct + zero);
        }

        int rowRank = rankMap.get(correct);

        int[] answer = new int[2];
        answer[0] = topRank;
        answer[1] = rowRank;

        return answer;
    }
}
