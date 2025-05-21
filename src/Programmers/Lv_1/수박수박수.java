package Programmers.Lv_1;

public class 수박수박수 {

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int count = n / 2;
        for (int i = 0; i < count; i++) {
            sb.append("수박");
        }

        if (n % 2 == 1) {
            sb.append("수");
        }

        return sb.toString();
    }
}
