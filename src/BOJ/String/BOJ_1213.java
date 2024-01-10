package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A']++;
        }

        int isOne = 0;
        int isOneIdx = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                isOneIdx = i;
                isOne++;
            }
        }

        if (isOne > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        StringBuilder tmp = new StringBuilder(sb.toString());

        if (isOne == 1) {
            sb.append((char) (isOneIdx + 'A')).append(tmp.reverse());
        } else {
            sb.append(tmp.reverse());
        }

        System.out.println(sb);
    }
}
