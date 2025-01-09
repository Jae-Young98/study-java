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

                if (c >= 'A' && c <= 'Z') {
                    sb.append('_').append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            sb.append('\n');

            sb.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).append('\n');
        } else if (num == 2) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '_') {
                    sb.append(Character.toUpperCase(str.charAt(i + 1)));
                    i++;
                } else {
                    sb.append(c);
                }
            }
            String temp = sb.toString();
            sb.append('\n');

            sb.append(str).append('\n');

            sb.append(Character.toUpperCase(temp.charAt(0))).append(temp.substring(1)).append('\n');
        } else {
            sb.append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).append('\n');

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c >= 'A' && c <= 'Z') {
                    if (i == 0) {
                        sb.append(Character.toLowerCase(c));
                    } else {
                        sb.append('_').append(Character.toLowerCase(c));
                    }
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
