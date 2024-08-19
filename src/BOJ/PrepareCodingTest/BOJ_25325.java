package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_25325 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                map.put(str, map.get(str) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            if (map.get(o1) - map.get(o2) == 0) {
                return o1.compareTo(o2);
            }
            return map.get(o2) - map.get(o1);
        });

        for (int i = 0; i < n; i++) {
            System.out.println(keySet.get(i) + " " + map.get(keySet.get(i)));
        }
    }
}
