package Programmers.Lv_1;

public class 신규_아이디_추천 {

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        String answer = "";

        // 1
        new_id = new_id.toLowerCase();

        // 2
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)
                    || c == '-' || c == '_' || c == '.') {
                answer += c;
            }
        }

        // 3
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        // 4
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5
        if (answer.isEmpty()) {
            answer += "a";
        }

        // 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);

            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}
