package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'A'] += (int)Math.pow(10, str.length() - 1 - j);
            }
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int num = 9;
        int i = 0;
        int result = 0;
        while(arr[i] != 0) {
            result += arr[i] * num;
            i++;
            num--;
        }
        System.out.println(result);
    }
}
