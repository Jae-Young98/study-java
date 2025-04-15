package Programmers.Lv_1;

import java.util.Arrays;

public class 공원 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 3, 2},
                new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}}));
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {
            for (int j = 0; j < park.length; j++) {
                for (int k = 0; k < park[j].length; k++) {
                    if (park[j][k].equals("-1")) {
                        if (canPlace(j, k, mats[i], park)) {
                            return mats[i];
                        }
                    }
                }
            }
        }

        return answer;
    }

    private static boolean canPlace(int x, int y, int matSize, String[][] park) {
        if (x + matSize - 1 >= park.length || y + matSize - 1 >= park[x].length) {
            return false;
        }

        for (int i = 0; i < matSize; i++) {
            for (int j = 0; j < matSize; j++) {
                if (!park[x + i][y + j].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}
