package Programmers.Lv_2;

import java.util.HashSet;
import java.util.Set;

public class 연속된_부분_수열_합의_개수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }

    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;

                for (int k = j; k < j + i; k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
