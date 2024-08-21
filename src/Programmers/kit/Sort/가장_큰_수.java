package Programmers.kit.Sort;

import java.util.Arrays;

public class 가장_큰_수 {

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strArr[0].equals("0")) {
            return "0";
        }

        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
    }

}
