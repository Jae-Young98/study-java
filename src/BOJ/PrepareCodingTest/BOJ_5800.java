package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_5800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Integer[] arr;
        int k = Integer.parseInt(br.readLine());
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            arr = new Integer[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
            }

            sb.append("Class ").append(i).append('\n');
            sb.append("Max ").append(max).append(", Min ").append(min);

            Arrays.sort(arr, Collections.reverseOrder());
            int maxGap = Integer.MIN_VALUE;
            for (int j = 0; j < n - 1; j++) {
                int gap = arr[j] - arr[j + 1];
                maxGap = Math.max(maxGap, gap);
            }
            sb.append(", Largest gap ").append(maxGap).append('\n');
        }

        System.out.print(sb);
    }
}
