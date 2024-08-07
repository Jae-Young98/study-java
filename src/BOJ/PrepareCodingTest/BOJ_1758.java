package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        long result = 0;
        int rank = 1;
        for (long i : arr) {
            long tip = i - (rank - 1);

            if (tip < 0) {
                tip = 0;
            }

            result += tip;
            rank++;
        }

        System.out.println(result);
    }
}
