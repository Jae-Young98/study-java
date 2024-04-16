package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            arr[i] = num;
            sum += num;
        }

        // 산술평균
        double avg = (double) sum / n;
        sb.append((int) Math.round(avg)).append('\n');

        // 중앙값
        Arrays.sort(arr);
        sb.append(arr[n / 2]).append('\n');

        // 최빈값
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        int maxCount = map.get(keySet.get(0));
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == maxCount) {
                list.add(m.getKey());
            }
        }

        Collections.sort(list);
        if (list.size() > 1) {
            sb.append(list.get(1)).append('\n');
        } else {
            sb.append(list.get(0)).append('\n');
        }

        // 범위
        sb.append(arr[n - 1] - arr[0]).append('\n');

        System.out.print(sb);
    }
}
