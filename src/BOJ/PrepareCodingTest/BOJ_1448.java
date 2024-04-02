package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int result = -1;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] < arr[i + 1] + arr[i + 2]) {
                result = Math.max(result, arr[i] + arr[i + 1] + arr[i + 2]);
            }
        }

        System.out.println(result);
    }
}
