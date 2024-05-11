package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11663 {

    static int n;
    static int m;
    static int[] dot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dot = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(x, y)).append('\n');
        }

        System.out.print(sb);
    }

    public static int binarySearch(int x, int y) {
        int left = 0;
        int right = dot.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dot[mid] > y) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int end = right + 1;

        left = 0;
        right = dot.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dot[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int start = left;

        return end - start;
    }
}
