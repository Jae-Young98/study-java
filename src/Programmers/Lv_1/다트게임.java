package Programmers.Lv_1;

public class 다트게임 {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                idx++;

                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    scores[idx] = 10;
                    i++;
                } else {
                    scores[idx] = c - '0';
                }
            } else if (c == 'D') {
                scores[idx] *= scores[idx];
            } else if (c == 'T') {
                scores[idx] *= scores[idx] * scores[idx];
            } else if (c == '*') {
                scores[idx] *= 2;
                if (idx - 1 >= 0) {
                    scores[idx - 1] *= 2;
                }
            } else if (c == '#') {
                scores[idx] *= -1;
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}
