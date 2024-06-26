package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long l = 0;
        long r = (long) arr[n - 1] * m;
        long result = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                long count = mid / arr[i];

                if (sum >= m) {
                    break;
                }
                sum += count;
            }

            if (sum >= m) {
                r = mid - 1;
                result = Math.min(result, mid);
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
}
