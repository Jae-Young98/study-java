package Programmers.Lv_1;

public class 옹알이2 {

    public static void main(String[] args) {

    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            String str = babbling[i];
            if (str.contains("ayaaya") || str.contains("yeye")
                    || str.contains("woowoo") || str.contains("mama")) {
                continue;
            }

            str = str.replace("aya", " ");
            str = str.replace("ye", " ");
            str = str.replace("woo", " ");
            str = str.replace("ma", " ");
            str = str.replace(" ", "");
            if (str.length() == 0) {
                answer++;
            }

        }
        return answer;
    }
}
