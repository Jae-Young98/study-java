package Programmers.Lv_1;

public class 두_정수_사이의_합 {

    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, 3));
    }

    public static long solution(int a, int b) {
        if (a == b) {
            return a;
        }

        long result = 0;

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for (int s = min; s <= max; s++) {
            result += s;
        }

        return result;
    }
}
