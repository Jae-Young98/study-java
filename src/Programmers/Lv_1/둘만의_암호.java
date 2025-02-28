package Programmers.Lv_1;

import java.util.HashSet;
import java.util.Set;

public class 둘만의_암호 {

    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> skipSet = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) {
            skipSet.add((int) skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            int idx = 0;
            while (idx < index) {
                c++;
                idx++;

                if (c > 'z') {
                    c = 'a';
                }

                if (skipSet.contains(c)) {
                    idx--;
                }
            }

            sb.append((char) c);
        }
        return sb.toString();
    }
}
