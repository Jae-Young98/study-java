package Programmers.Lv_1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {
        String strings[] = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) - o2.charAt(n) == 0) {
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) - o2.charAt(n);
            }
        });

        return strings;
    }
}
