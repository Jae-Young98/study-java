package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map.put(Integer.parseInt(st.nextToken()), 1);
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (map.containsKey(x)) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
