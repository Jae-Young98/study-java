package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;

        int next = arr[start];
        if (!visited[next]) {
            dfs(arr[start]);
        }
    }
}
