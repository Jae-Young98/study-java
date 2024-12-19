package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9324 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] alpha = new int[26];
            boolean flag = true;
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int idx = c - 'A';
                alpha[idx]++;

                if (alpha[idx] == 3) {
                    if (j == str.length() - 1) {
                        flag = false;
                        break;
                    }

                    if (c != str.charAt(j + 1)) {
                        flag = false;
                        break;
                    }

                    j++;
                    alpha[idx] = 0;
                }
            }

            if (flag) {
                sb.append("OK").append('\n');
            } else {
                sb.append("FAKE").append('\n');
            }
        }
        System.out.print(sb);
    }
}
