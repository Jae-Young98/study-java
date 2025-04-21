package Programmers.Lv_1;

import java.util.Arrays;

public class 서울에서_김서방_찾기 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }

    public static String solution(String[] seoul) {
        int idx = Arrays.asList(seoul).indexOf("Kim");

        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ").append(idx).append("에 있다");
        return sb.toString();
    }
}
