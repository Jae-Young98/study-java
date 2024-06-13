package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {

    static int[][] arr;
    static int[][] tempArr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;

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

        int result = 0;
        int count = 0;

        // 빙하가 2개 이상일 경우 종료, 다 녹으면 0
        while ((count = countIceberg()) < 2) {
            if (count == 0) {
                System.out.println(0);
                return;
            }

            bfs();
            result++;
        }

        System.out.println(result);
    }

    public static int countIceberg() {
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (arr[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    sea++;
                }
            }

            if (arr[p.x][p.y] - sea < 0) {
                arr[p.x][p.y] = 0;
            } else {
                arr[p.x][p.y] -= sea;
            }
        }
    }
}
