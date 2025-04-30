package Programmers.Lv_1;

public class 핸드폰_번호_가리기 {

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }

    public static String solution(String phone_number) {
        int len = phone_number.length();
        phone_number = phone_number.substring(len - 4);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - phone_number.length(); i++) {
            sb.append("*");
        }
        sb.append(phone_number);

        return sb.toString();
    }
}
