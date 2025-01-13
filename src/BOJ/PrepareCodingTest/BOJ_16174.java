package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16174 {
    static int[][] arr;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int N;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(new Point(0, 0));
        System.out.println("Hing");
    }

    static void dfs(Point p) {
        int jump = arr[p.x][p.y];
        if (jump == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int i = 0; i < 2; i++) {
            int row = p.x + dx[i] * jump;
            int col = p.y + dy[i] * jump;

            if (row < 0 || col < 0 || row >= N || col >= N)
                continue;
            if (visited[row][col])
                continue;

            visited[row][col] = true;
            dfs(new Point(row, col));
        }
    }
}
