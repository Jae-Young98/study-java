package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9322 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int[] pos = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String key = st.nextToken();
                map.put(key, i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String key = st.nextToken();
                pos[i] = map.get(key);
            }

            st = new StringTokenizer(br.readLine());
            String[] result = new String[n];
            for (int i = 0; i < n; i++) {
                result[pos[i]] = st.nextToken();
            }

            for (int i = 0; i < n; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
