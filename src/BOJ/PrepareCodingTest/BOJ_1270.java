package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1270 {

    static int t;
    static Map<Long, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map = new HashMap<>();

            t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                long x = Long.parseLong(st.nextToken());
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            search();
        }

        System.out.print(sb);
    }

    public static void search() {
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() > t / 2) {
                sb.append(entry.getKey()).append('\n');
                return;
            }
        }
        sb.append("SYJKGW").append('\n');
    }
}
