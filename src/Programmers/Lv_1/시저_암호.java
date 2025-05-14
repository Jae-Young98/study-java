package Programmers.Lv_1;

public class 시저_암호 {

    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ((c - 'A' + n) % 26 + 'A');
                } else {
                    c = (char) ((c - 'a' + n) % 26 + 'a');
                }
            }

            sb.append(c);
        }
        return sb.toString();
    }
}
