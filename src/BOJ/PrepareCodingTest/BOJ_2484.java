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

public class BOJ_2484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> list;
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int x = Integer.parseInt(st.nextToken());
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            list = new ArrayList<>(map.keySet());
            list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

            int top = list.get(0);
            int count = map.get(top);

            int prize = 0;
            if (count == 4) {
                prize = 50000 + top * 5000;
            } else if (count == 3) {
                prize = 10000 + top * 1000;
            } else if (count == 2) {
                int next = list.get(1);
                int nextCount = map.get(next);

                if (nextCount == 2) {
                    prize = 2000 + top * 500 + next * 500;
                } else {
                    prize = 1000 + top * 100;
                }
            } else {
                list.sort(Comparator.reverseOrder());
                prize = list.get(0) + 100;
            }

            result = Math.max(result, prize);
        }

        System.out.println(result);
    }
}
