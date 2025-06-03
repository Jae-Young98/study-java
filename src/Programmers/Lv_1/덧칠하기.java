package Programmers.Lv_1;

public class 덧칠하기 {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(solution(5, 4, new int[]{1, 3}));
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4}));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;

        int s = section[0];

        for (int i = 0; i < section.length; i++) {
            int num = section[i];
            if (s + m > num) {
                continue;
            }

            s = num;
            answer++;
        }

        return answer;
    }
}
