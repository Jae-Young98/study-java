package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13702 {

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

        long l = 1;
        long r = arr[n - 1];
        long result = 0;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (mid == 0) {
                continue;
            }

            long count = 0;
            for (int i = 0; i < n; i++) {
                count += (arr[i] / mid);
            }

            if (count >= k) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
}
