package Programmers.Lv_1;

public class 부족한_금액_계산하기 {

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        long total = 0;
        for (int i = 1; i <= count; i++) {
            total += ((long) price * i);
        }

        if (money > total) {
            return 0;
        }
        return total - money;
    }
}
