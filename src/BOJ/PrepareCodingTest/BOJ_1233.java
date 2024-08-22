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

public class BOJ_1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    int sum = i + j + k;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Value = map.get(o1);
                int o2Value = map.get(o2);
                if (o1Value == o2Value) {
                    return o1 - o2;
                }

                return o2Value - o1Value;
            }
        });

        System.out.println(list.get(0));
    }
}
