package Programmers.Lv_1;

public class 평균_구하기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
    }

    public static double solution(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }
}
