package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int increase = 1;
        int decrease = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                increase++;
            } else {
                increase = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                decrease++;
            } else {
                decrease = 1;
            }

            max = Math.max(max, Math.max(increase, decrease));
        }

        System.out.println(max);
    }
}
