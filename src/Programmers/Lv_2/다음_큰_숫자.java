package Programmers.Lv_2;

public class 다음_큰_숫자 {

    public static void main(String[] args) {
        System.out.println(solution(70));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int currentOne = countOne(n);

        while (true) {
            n++;
            int nextOne = countOne(n);

            if (currentOne == nextOne) {
                break;
            }
        }

        return n;
    }

    public static int countOne(int n) {
        int result = 1;

        while (n > 1) {
            if (n % 2 == 1) {
                result++;
            }

            n /= 2;
        }

        return result;
    }
}
