package Programmers.Lv_1;

import java.util.HashSet;
import java.util.Set;

public class 없는_숫자_더하기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }

    public static int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            set.add(i);
        }

        for (int x : numbers) {
            set.remove(x);
        }

        int answer = 0;
        for (int x : set) {
            answer += x;
        }

        return answer;
    }
}
