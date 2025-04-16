package Programmers.Lv_1;

public class 유연근무제 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{700, 800, 1100},
                new int[][]{{710, 2359, 1050, 700, 650, 631, 659},
                        {800, 801, 805, 800, 759, 810, 809},
                        {1105, 1001, 1002, 600, 1059, 1001, 1100}},
                5));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int limit = schedules[i] + 10;
            if (limit % 100 >= 60) {
                limit += 40;
            }

            int day = startday;
            boolean hasLate = false;
            for (int j = 0; j < timelogs[i].length; j++) {
                if ((startday + j) % 7 > 0 && (startday + j) % 7 < 6) {
                    if (timelogs[i][j] > limit) {
                        hasLate = true;
                        break;
                    }
                }
            }

            if (!hasLate) {
                answer++;
            }
        }

        return answer;
    }
}
