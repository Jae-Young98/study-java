package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int n;
    static int m;
    static int result = 0;

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    queue.offer(new Point(i, j));
                    int distance = bfs(i, j);

                    result = Math.max(result, distance);
                }
            }
        }
        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        int [][] distance = new int[n][m];
        distance[x][y] = 0;

        visited = new boolean[n][m];
        visited[x][y] = true;

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    result = Math.min(result, distance[p.x][p.y] + 1);
                }

                if (arr[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
        return result;
    }
}
