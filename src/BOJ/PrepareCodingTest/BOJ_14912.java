package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String d = st.nextToken();
        char target = d.charAt(0);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            String x = String.valueOf(i);

            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) == target) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
