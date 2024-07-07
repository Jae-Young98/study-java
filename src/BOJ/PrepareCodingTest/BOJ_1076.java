package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();

        map.put("black", "0");
        map.put("brown", "1");
        map.put("red", "2");
        map.put("orange", "3");
        map.put("yellow", "4");
        map.put("green", "5");
        map.put("blue", "6");
        map.put("violet", "7");
        map.put("grey", "8");
        map.put("white", "9");

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        long sum = Long.parseLong(map.get(s1) + map.get(s2));
        long result = (long) (sum * Math.pow(10.0, Integer.parseInt(map.get(s3))));

        System.out.println(result);
    }
}
