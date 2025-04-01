package Programmers.Lv_2;

public class JadenCase_문자열_만들기 {

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution("1aa  Aww e"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split(" ");
        for (String string : arr) {
            if (string.isEmpty()) {
                sb.append(' ');
            } else {
                sb.append(string.substring(0, 1).toUpperCase());
                sb.append(string.substring(1).toLowerCase());
                sb.append(' ');
            }
        }

        if (s.charAt(s.length() - 1) == ' ') {
            return sb.toString();
        }

        return sb.substring(0, sb.length() - 1);
    }
}
