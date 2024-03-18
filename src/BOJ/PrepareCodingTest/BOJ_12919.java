package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {

    static StringBuilder sb;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        dfs(s, t);
        System.out.println(result);
    }

    public static void dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                result = 1;
            }
            return;
        }

        if (t.charAt(0) == 'B') {
            String sub = t.substring(1);
            sb = new StringBuilder(sub);
            String str = sb.reverse().toString();

            dfs(s, str);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, t.substring(0, t.length() - 1));
        }
    }
}
