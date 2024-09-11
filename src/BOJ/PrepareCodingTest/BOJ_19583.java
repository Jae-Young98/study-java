package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s, e, q;
        String[] time = st.nextToken().split(":");
        s = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);

        time = st.nextToken().split(":");
        e = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);

        time = st.nextToken().split(":");
        q = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);

        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            time = st.nextToken().split(":");
            int t = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            String member = st.nextToken();

            if (t <= s) {
                map.put(member, map.getOrDefault(member, 0) + 1);
            }

            if (t >= e && t <= q) {
                if (map.containsKey(member)) {
                    result++;
                    map.remove(member);
                }
            }
        }

        System.out.println(result);
    }
}
