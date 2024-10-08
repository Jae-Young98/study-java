package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_25192 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        br.readLine();
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                result += map.size();
                map = new HashMap<>();
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        result += map.size();

        System.out.println(result);
    }
}
