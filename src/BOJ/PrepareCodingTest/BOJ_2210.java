package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2210 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int n = 5;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        set = new HashSet<>();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String str = new String();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, 0, str);
            }
        }

        System.out.println(set.size());
    }

    public static void dfs(int x, int y, int depth, String str) {
        if (depth == 6) {
            set.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            dfs(nx, ny, depth + 1, str + arr[x][y]);
        }
    }
}
