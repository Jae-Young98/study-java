package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n - 1];
            long result = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (max > arr[i]) {
                    result += max - arr[i];
                } else {
                    max = arr[i];
                }
            }
            sb.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.print(sb);
    }
}
