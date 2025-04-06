package Programmers.Lv_2;

public class N개의_최소_공배수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }

    public static int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int g = gcd(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / g;
        if (arr.length == 2) {
            return answer;
        }

        for (int i = 2; i < arr.length; i++) {
            g = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / g;
        }

        return answer;
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
