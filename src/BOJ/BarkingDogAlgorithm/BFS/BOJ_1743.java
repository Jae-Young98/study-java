package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r - 1][c - 1] = 1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int bfs(int x, int y) {
        queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Point(x, y));

        int count = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
