package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[s];
        long sum = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        long l = 1;
        long r = arr[s - 1];
        long max = 0;
        while (l <= r) {
            long mid = (l + r) / 2;

            long count = 0;
            for (int i = 0; i < s; i++) {
                count += (arr[i] / mid);
            }

            if (count >= c) {
                max = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        long result = sum - (max * c);
        System.out.println(result);
    }
}
