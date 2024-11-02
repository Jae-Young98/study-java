package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();
            map.put(name, type);
        }

        int score = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            String getType = map.getOrDefault(name, "L");
            if (getType.equals("W")) {
                score += w;

                if (score >= g) {
                    System.out.println("I AM NOT IRONMAN!!");
                    return;
                }
            } else {
                score -= l;

                if (score < 0) {
                    score = 0;
                }
            }
        }

        System.out.println("I AM IRONMAN!!");
    }
}
