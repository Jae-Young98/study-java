package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] alpha;
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append(1).append(' ').append(1).append('\n');
                continue;
            }

            alpha = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < str.length(); i++) {
                if (alpha[str.charAt(i) - 'a'] < k) {
                    continue;
                }

                int count = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(i)) {
                        count++;
                    }

                    if (count == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                sb.append(-1).append('\n');
            } else {
                sb.append(min).append(' ').append(max).append('\n');
            }
        }

        System.out.print(sb);
    }
}
