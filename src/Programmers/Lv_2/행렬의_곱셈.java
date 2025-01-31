package Programmers.Lv_2;

import java.util.Arrays;

public class 행렬의_곱셈 {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };

        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int x1 = arr1.length;
        int x2 = arr1[0].length;
        int y1 = arr2.length;
        int y2 = arr2[0].length;

        int[][] result = new int[x1][y2];

        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < y2; j++) {
                for (int k = 0; k < y1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}
