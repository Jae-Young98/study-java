package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3184 {

    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int wolf;
    static int sheep;

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

        int v = 0;
        int o = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((arr[i][j] == 'v' || arr[i][j] == 'o') && !visited[i][j]) {
                    wolf = 0;
                    sheep = 0;
                    dfs(i, j);

                    if (sheep > wolf) {
                        wolf = 0;
                    } else {
                        sheep = 0;
                    }

                    v += wolf;
                    o += sheep;
                }
            }
        }
        System.out.printf("%d %d\n", o, v);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if (arr[x][y] == 'v') {
            wolf++;
        } else if (arr[x][y] == 'o') {
            sheep++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || arr[nx][ny] == '#') {
                continue;
            }

            dfs(nx, ny);
        }
    }
}
