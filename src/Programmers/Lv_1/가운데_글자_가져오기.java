package Programmers.Lv_1;

public class 가운데_글자_가져오기 {

    public static void main(String[] args) {
        System.out.println(solution("aerwar"));
        System.out.println(solution("aaaaadaaaaa"));
    }

    public static String solution(String s) {
        int len = s.length();

        String answer = "";
        if (len % 2 == 0) {
            answer += s.charAt((len / 2) - 1);
            answer += s.charAt(len / 2);
        } else {
            answer += s.charAt(len / 2);
        }
        return answer;
    }
}
