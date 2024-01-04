package BOJ.BarkingDogAlgorithm.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            if (log.equals("enter")) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            } else {
                map.remove(name);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Collections.reverseOrder());

        for (String key : list) {
            sb.append(key).append('\n');
        }
        System.out.print(sb);
    }
}
