package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_25757 {

    static final int F = 2;
    static final int O = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                continue;
            }

            map.put(name, 1);
        }
        System.out.println(getPlayGameCount(map, game));
    }

    public static int getPlayGameCount(Map<String, Integer> map, String game) {
        if (game.equals("Y")) {
            return map.size();
        } else if (game.equals("F")) {
            return map.size() / F;
        } else {
            return map.size() / O;
        }
    }
}
