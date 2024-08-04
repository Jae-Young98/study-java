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

public class BOJ_2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> index = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            index.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {

            if (map.get(o1) == map.get(o2)) {
                return index.indexOf(o1) - index.indexOf(o2);
            }
            return map.get(o2) - map.get(o1);
        });

        for (int i : list) {
            int count = map.get(i);

            for (int k = 0; k < count; k++) {
                System.out.print(i + " ");
            }
        }
    }
}
