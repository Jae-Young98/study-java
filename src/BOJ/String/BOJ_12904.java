package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        sb.append(br.readLine());
        int result = 0;
        while (sb.length() > S.length()) {
            char c = sb.charAt(sb.length() - 1);
            if (c == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (c == 'B') {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }

            if (S.equals(sb.toString())) {
                result = 1;
                break;
            }
        }
        System.out.println(result);
    }
}
