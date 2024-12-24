package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int[] arr = new int[n];
            int[] result = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int l = 0;
            int r = n - 1;
            for (int j = 0; j < n; j++) {
                if (j % 2 != 0) {
                    result[l] = arr[j];
                    l++;
                } else {
                    result[r] = arr[j];
                    r--;
                }
            }

            min = Math.abs(result[0] - result[n - 1]);
            for (int j = 1; j < n; j++) {
                min = Math.max(min, Math.abs(result[j] - result[j - 1]));
            }
            System.out.println(min);
        }
    }
}
