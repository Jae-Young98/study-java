package Programmers.Lv_1;

public class 약수의_개수와_덧셈 {

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            int count = 0;

            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    count++;
                    if (i / j != j) {
                        count++;
                    }
                }
            }

            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }
}
