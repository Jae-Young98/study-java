package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> indexMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            String index = String.valueOf(i);
            indexMap.put(name, index);
            nameMap.put(index, name);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (indexMap.containsKey(str)) {
                sb.append(indexMap.get(str)).append('\n');
            } else {
                sb.append(nameMap.get(str)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
