package Programmers.Lv_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 최댓값과_최솟값 {

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");

        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        answer.append(list.get(0)).append(" ").append(list.get(list.size() - 1));
        return answer.toString();
    }
}
