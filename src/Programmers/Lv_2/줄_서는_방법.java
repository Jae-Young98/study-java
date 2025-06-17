package Programmers.Lv_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄_서는_방법 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        k--;
        int idx = 0;
        while (idx < n) {
            factorial = factorial / (n - idx);
            answer[idx] = list.remove((int) (k / factorial));
            idx++;
            k = k % factorial;
        }

        return answer;
    }
}
