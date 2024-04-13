package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;

            if (getInstallCount(mid) < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static int getInstallCount(int distance) {
        int count = 1;
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];

            if (now - prev >= distance) {
                count++;
                prev = now;
            }
        }

        return count;
    }
}
