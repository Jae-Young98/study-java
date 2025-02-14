package Programmers.Lv_1;

import java.util.ArrayList;
import java.util.List;

public class 햄버거_만들기 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] arr2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(arr));
        System.out.println(solution(arr2));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);

            if (list.size() >= 4) {
                if (list.get(list.size() - 4) == 1
                        && list.get(list.size() - 3) == 2
                        && list.get(list.size() - 2) == 3
                        && list.get(list.size() - 1) == 1) {
                    answer++;
                    for (int j = 0; j < 4; j++) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return answer;
    }
}
