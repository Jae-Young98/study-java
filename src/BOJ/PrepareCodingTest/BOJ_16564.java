package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int l = arr[0];
        int r = arr[n - 1];
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] < mid) {
                    sum += (mid - arr[i]);
                }
            }

            if (sum <= k) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
