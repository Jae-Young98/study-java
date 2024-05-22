package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3187 {

    static char[][] arr;
    static boolean[][] visited;
    static int v;
    static int k;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int wolf = 0;
        int sheep = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((arr[i][j] == 'k' || arr[i][j] == 'v') && !visited[i][j]) {
                    v = 0;
                    k = 0;
                    dfs(i, j);

                    if (k > v) {
                        v = 0;
                    } else {
                        k = 0;
                    }

                    wolf += v;
                    sheep += k;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        if (arr[x][y] == 'v') {
            v++;
        } else if (arr[x][y] == 'k') {
            k++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == '#' || visited[nx][ny]) {
                continue;
            }

            dfs(nx, ny);
        }
    }
}
