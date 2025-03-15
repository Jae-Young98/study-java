package Programmers.Lv_1;

import java.util.Arrays;

public class 대충_만든_자판 {

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                int index = 101;
                for (int k = 0; k < keymap.length; k++) {
                    int min = keymap[k].indexOf(targets[i].charAt(j));

                    if (min != -1) {
                        index = Math.min(index, min);
                    }
                }

                if (index == 101) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += index + 1;
            }
        }
        return answer;
    }
}
