package BOJ.BarkingDogAlgorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                int c;
                if (str.charAt(j) == '-') {
                    c = 0;
                } else {
                    c = 1;
                }
                arr[i][j] = c;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (arr[i][j] == 0) {
                    dfs(i, j, true);
                } else {
                    dfs(i, j, false);
                }
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int i, int j, boolean isDash) {
        visited[i][j] = true;
        if (isDash) {
            j++;
            if (j < m && arr[i][j] == 0) {
                dfs(i, j, true);
            }
        } else {
            i++;
            if (i < n && arr[i][j] == 1) {
                dfs(i, j, false);
            }
        }
    }
}
