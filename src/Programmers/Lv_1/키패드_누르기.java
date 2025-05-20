package Programmers.Lv_1;

public class 키패드_누르기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        // *
        int l = 10;
        // #
        int r = 12;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                l = num;
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                r = num;
            } else {
                if (num == 0) {
                    num = 11;
                }

                int lDistance = Math.abs(num - l) / 3 + Math.abs(num - l) % 3;
                int rDistance = Math.abs(num - r) / 3 + Math.abs(num - r) % 3;

                if (lDistance < rDistance) {
                    answer += "L";
                    l = num;
                } else if (lDistance > rDistance) {
                    answer += "R";
                    r = num;
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        l = num;
                    } else {
                        answer += "R";
                        r = num;
                    }
                }
            }
        }
        return answer;
    }
}
