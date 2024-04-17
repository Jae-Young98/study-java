package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        // W = 0, B = 1
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                if (c == 'W') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        int wTotal = 0;
        int bTotal = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    wTotal += bfs();
                } else if (!visited[i][j] && arr[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    bTotal += bfs();
                }
            }
        }
        sb.append(wTotal).append(' ').append(bTotal).append('\n');
        System.out.print(sb);
    }

    public static int bfs() {
        int count = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (arr[nx][ny] == arr[p.x][p.y] && !visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return (int) Math.pow(count, 2);
    }
}
