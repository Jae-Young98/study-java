package BOJ.BarkingDogAlgorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        combination(1, n, m);
    }

    public static void combination(int start, int n, int r) {
        if (r == 0) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i <= n; i++) {
            visited[i] = true;
            combination(i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
