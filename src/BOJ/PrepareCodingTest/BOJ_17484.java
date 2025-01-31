package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17484 {

    static int n;
    static int m;
    static int[][] arr;
    static int[] dy = {-1, 0, 1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i, -1, 0);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int dir, int sum) {
        if (x == n) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (dir == i) {
                continue;
            }

            int ny = y + dy[i];
            if (ny < 0 || ny >= m) {
                continue;
            }

            dfs(x + 1, ny, i, sum + arr[x][y]);
        }
    }
}
