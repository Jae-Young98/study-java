package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                sb.append(c);
                continue;
            }
            int n = (int)c + 13;

            //대문자일 때 90보다 크면 26 빼기
            if (Character.isUpperCase(c) && n > 90) {
                n -= 26;
            }

            //소문자일 때 122보다 크면 26 빼기
            if (Character.isLowerCase(c) && n > 122) {
                n -= 26;
            }
            sb.append((char)n);
        }

        System.out.println(sb);
    }
}
