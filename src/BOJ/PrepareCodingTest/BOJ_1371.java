package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1371 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        String str = "";
        while ((str = br.readLine()) != null) {

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != ' ') {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }

        List<Character> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return o1 - o2;
            }

            return map.get(o2) - map.get(o1);
        });

        int max = map.get(keySet.get(0));
        for (Character key : keySet) {
            if (map.get(key) < max) {
                return;
            }

            if (map.get(key) == max) {
                System.out.print(key);
            }
        }
    }
}
