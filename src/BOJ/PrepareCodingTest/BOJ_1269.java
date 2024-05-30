package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> aSet = new HashMap<>();
        Map<Integer, Integer> bSet = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            aSet.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            bSet.put(Integer.parseInt(st.nextToken()), 1);
        }

        int result = 0;
        for (int x : aSet.keySet()) {
            if (!bSet.containsKey(x)) {
                result++;
            }
        }
        for (int x : bSet.keySet()) {
            if (!aSet.containsKey(x)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
