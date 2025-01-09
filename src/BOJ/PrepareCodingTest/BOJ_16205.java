package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        if (num == 1) {
            sb.append(str).append('\n');

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (Character.isUpperCase(c)) {
                    sb.append('_').append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            sb.append('\n');

            sb.append(Character.toUpperCase(str.charAt(0)));
            str = str.substring(1);
            sb.append(str).append('\n');
        } else if (num == 2) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '_') {
                    sb.append(Character.toUpperCase(str.charAt(i + 1)));
                    i += 2;
                } else {
                    sb.append(c);
                }
            }
            String temp = sb.toString();
            sb.append('\n');

            sb.append(str).append('\n');

            sb.append(Character.toUpperCase(str.charAt(0)));
            sb.append(temp.substring(1)).append('\n');
        } else {
            sb.append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).append('\n');

            sb.append(Character.toLowerCase(str.charAt(0)));
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);

                if (Character.isUpperCase(c)) {
                    sb.append('_').append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            sb.append('\n');

            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }
}
