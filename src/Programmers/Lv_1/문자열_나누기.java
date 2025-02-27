package Programmers.Lv_1;

public class 문자열_나누기 {

    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }

    public static int solution(String s) {
        int answer = 0;
        int count = 0;
        int other = 0;
        char c = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (count == other) {
                answer++;
                c = s.charAt(i);
            }

            if (c == s.charAt(i)) {
                count++;
            } else {
                other++;
            }
        }

        return answer;
    }
}
