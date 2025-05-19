package Programmers.Lv_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 뉴스_클러스터링 {

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if (Character.isAlphabetic(first) && Character.isAlphabetic(second)) {
                String str = String.valueOf(first) + String.valueOf(second);
                list1.add(str);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (Character.isAlphabetic(first) && Character.isAlphabetic(second)) {
                String str = String.valueOf(first) + String.valueOf(second);
                list2.add(str);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        union.addAll(list2);

        double jakard = (double) intersection.size() / (double) union.size();

        if (union.isEmpty()) {
            jakard = 1;
        }

        return (int) (jakard * 65536);
    }
}
