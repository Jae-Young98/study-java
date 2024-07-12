package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
           int x = Integer.parseInt(br.readLine());
           int remain = x % 42;
           map.put(remain, map.getOrDefault(remain, 0) + 1);
        }

        System.out.println(map.size());
    }
}
