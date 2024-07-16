package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map;

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                String c = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (c.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    // 최댓값 삭제
                    if (num == 1) {
                        if (map.size() == 0) {
                            continue;
                        }

                        int v = map.get(map.lastKey());
                        if (v == 1) {
                            map.remove(map.lastKey());
                        } else {
                            map.put(map.lastKey(), v - 1);
                        }
                    } else {
                        // 최소값 삭제
                        if (map.size() == 0) {
                            continue;
                        }

                        int v = map.get(map.firstKey());
                        if (v == 1) {
                            map.remove(map.firstKey());
                        } else {
                            map.put(map.firstKey(), v - 1);
                        }
                    }
                }
            }
            if (map.size() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
