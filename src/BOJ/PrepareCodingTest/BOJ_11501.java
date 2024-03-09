package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 뒤에서부터 탐색하면 O(n)에 가능
            long result = 0;
            int max = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] <= max) {
                    result += (max - arr[i]);
                } else {
                    max = arr[i];
                }
            }
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
