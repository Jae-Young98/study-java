package Programmers.Lv_2;

import java.util.Arrays;

public class 카펫 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // yellow의 넓이는 (가로 - 2) * (세로 - 2)
        // yellow가 존재하기 위해선 가로 세로 길이가 3이상
        int carpet = brown + yellow;
        for (int i = 3; i <= carpet; i++) {
            int col = i;
            int row = carpet / col;

            if (row < 3) {
                continue;
            }

            if (row >= col) {
                if ((row - 2) * (col - 2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
}
