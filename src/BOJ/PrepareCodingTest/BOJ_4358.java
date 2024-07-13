package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        String str;
        double total = 0;
        while ((str = br.readLine()) != null) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            total++;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String name : list) {
            double count = map.get(name) * 100;
            double ratio = count / total;
            sb.append(name).append(" ").append(String.format("%.4f", ratio)).append('\n');
        }

        System.out.println(sb);
    }
}
