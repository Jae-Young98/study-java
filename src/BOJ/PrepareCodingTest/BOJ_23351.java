package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23351 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = k;
        }

        int day = 0;
        while (true) {
            if (arr[0] == 0) {
                break;
            }

            for (int i = 0; i < a; i++) {
                arr[i] += b;
            }

            for (int i = 0; i < n; i++) {
                arr[i] -= 1;
            }

            Arrays.sort(arr);
            day++;
        }

        System.out.println(day);
    }
}
