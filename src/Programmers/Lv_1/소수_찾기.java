package Programmers.Lv_1;

public class 소수_찾기 {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        boolean[] arr = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if (arr[i]) {
                continue;
            }

            for (int j = 2 * i; j <= 1000000; j += i) {
                arr[j] = true;
            }
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                answer++;
            }
        }

        return answer;
    }
}
