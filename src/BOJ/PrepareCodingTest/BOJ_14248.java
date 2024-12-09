package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14248 {

    static int n;
    static int s;
    static int[] arr;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        result = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());
        visited[s] = true;
        dfs(s);

        System.out.println(result);
    }

    static void dfs(int start) {
        int left = start - arr[start];
        int right = start + arr[start];

        if (left > 0 && !visited[left]) {
            visited[left] = true;
            result++;
            dfs(left);
        }

        if (right <= n && !visited[right]) {
            visited[right] = true;
            result++;
            dfs(right);
        }
    }
}
