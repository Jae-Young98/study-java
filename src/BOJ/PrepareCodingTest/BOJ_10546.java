package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_10546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();

            if (map.containsKey(str)) {
                int v = map.get(str);
                if (v > 1) {
                    map.put(str, v - 1);
                } else {
                    map.remove(str);
                }
            }
        }

        List<String> key = new ArrayList<>(map.keySet());
        System.out.println(key.get(0));
    }
}
