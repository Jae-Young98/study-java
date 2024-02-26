package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canLight(mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean canLight(int h) {
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - h <= prev) {
                prev = arr[i] + h;
            } else {
                return false;
            }
        }

        return n - prev <= 0;
    }
}
