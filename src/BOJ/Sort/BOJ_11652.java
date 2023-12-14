package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        int max = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            } else if (map.get(key) == max) {
                result = Math.min(result, key);
            }
        }

        System.out.println(result);
    }
}
