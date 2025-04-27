package Programmers.Lv_1;

public class 기사단원의_무기 {

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
        System.out.println(solution(10, 3, 2));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int cnt = 0;

            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    cnt++;
                } else if (i % j == 0) {
                    cnt += 2;
                }
            }

            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }
        return answer;
    }
}
