package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int l = 0;
            int r = n - 1;
            int near = Integer.MAX_VALUE;
            int count = 1;
            while (l < r) {
                int sum = arr[l] + arr[r];

                if (Math.abs(sum - k) == near) {
                    count++;
                } else if (Math.abs(sum - k) < near) {
                    count = 1;
                    near = Math.abs(sum - k);
                }

                if (sum == k) {
                    l++;
                    r--;
                } else if (sum < k) {
                    l++;
                } else {
                    r--;
                }
            }
            System.out.println(count);
        }
    }
}
