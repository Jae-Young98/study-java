package Programmers.Lv_1;

import java.util.*;
import java.io.*;

public class 두_개_뽑아서_더하기 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};
        int[] arr2 = {5, 0, 2, 7};

        System.out.println(Arrays.toString(solution(arr)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
