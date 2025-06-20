package Programmers.Lv_1;

public class 이상한_문자_만들기 {

    public static void main(String[] args) {
        System.out.println(solution("try"));
        System.out.println(solution("try hello world"));
        System.out.println(solution("try  hello   world"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                idx = 0;
            } else if (idx % 2 == 0) {
                arr[i] = arr[i].toUpperCase();
                idx++;
            } else {
                arr[i] = arr[i].toLowerCase();
                idx++;
            }

            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
