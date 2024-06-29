package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        int result = 0;
        while (true) {
            if (sum >= m) {
                sum -= arr[s];
                s++;
            } else if (e == n) {
                break;
            } else {
                sum += arr[e];
                e++;
            }

            if (sum == m) {
                result++;
            }
        }

        System.out.println(result);
    }
}
