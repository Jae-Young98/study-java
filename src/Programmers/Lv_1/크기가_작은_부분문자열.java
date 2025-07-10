package Programmers.Lv_1;

public class 크기가_작은_부분문자열 {

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.println(solution("10203", "15"));
    }

    public static int solution(String t, String p) {
        int answer = 0;

        long pLong = Long.parseLong(p);
        int len = p.length();

        StringBuilder sb;
        for (int i = 0; i < t.length() - len + 1; i++) {
            sb = new StringBuilder();
            for (int j = i; j < i + len; j++) {
                sb.append(t.charAt(j));
            }

            if (Long.parseLong(sb.toString()) <= pLong) {
                answer++;
            }
        }

        return answer;
    }
}
