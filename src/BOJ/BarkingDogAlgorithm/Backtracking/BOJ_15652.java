package BOJ.BarkingDogAlgorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[10];
        visited = new boolean[10];
        backTracking(1, 0);

        System.out.print(sb);
    }

    public static void backTracking(int start, int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[k] = i;
            backTracking(i, k + 1);
        }
    }
}
