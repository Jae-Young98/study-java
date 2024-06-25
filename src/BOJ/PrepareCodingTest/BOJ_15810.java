package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long l = 0;
        long r = (long) arr[n - 1] * m;
        long result = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / arr[i]);
            }

            if (sum >= m) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
}
