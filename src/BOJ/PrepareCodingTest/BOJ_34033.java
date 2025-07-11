package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_34033 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String item = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            map.put(item, (int) (price * 1.05));
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String item = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            if (price > map.get(item)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
