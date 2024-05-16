package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13565 {

    static int[][] arr;
    static boolean[][] visited;
    static boolean result;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 0) {
                dfs(0, i);
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if (x == m - 1 && arr[x][y] == 0) {
            result = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || arr[nx][ny] != 0) {
                continue;
            }

            if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
