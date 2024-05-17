package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int number = Integer.parseInt(br.readLine());
            int[] arr = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[x]++;
            }

            int result = 0;
            int max = 0;
            for (int i = 100; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                    result = i;
                }
            }

            sb.append('#').append(number).append(' ').append(result).append('\n');
        }

        System.out.print(sb);
    }
}
