package Programmers.Lv_1;

public class 문자열_다루기_기본 {

    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
        System.out.println(solution("11111"));
    }

    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
