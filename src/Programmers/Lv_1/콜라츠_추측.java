package Programmers.Lv_1;

public class 콜라츠_추측 {

    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int answer = 0;

        long number = (long) num;
        while (answer <= 500) {
            if (number == 1) {
                break;
            }

            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = (number * 3) + 1;
            }
            answer++;
        }

        if (answer == 501) {
            return -1;
        }

        return answer;
    }
}
