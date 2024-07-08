package Programmers.Lv_1;

public class 문자열_내_p와_y의_개수 {

    public static boolean solution(String s) {
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') {
                p++;
            } else if (c == 'y' || c == 'Y') {
                y++;
            }
        }

        return p == y;
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }
}
