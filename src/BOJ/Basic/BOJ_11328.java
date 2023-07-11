package BOJ.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] alpha = new int[26];
            boolean flag = true;
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            for (int j = 0; j < str1.length(); j++) {
                alpha[str1.charAt(j) - 'a']++;
            }
            for (int j = 0; j < str2.length(); j++) {
                alpha[str2.charAt(j) - 'a']--;
            }
            for (int j = 0; j < alpha.length; j++) {
                if (alpha[j] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                sb.append("Possible").append('\n');
            } else {
                sb.append("Impossible").append('\n');
            }
        }
        System.out.println(sb);
    }
}
