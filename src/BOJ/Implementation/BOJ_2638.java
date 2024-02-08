package BOJ.Implementation;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {

    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] airSpace;
    static int cheese = 0;
    static int result = 0;
    static Queue<Point> queue;

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
                if (arr[i][j] == 1) {
                    cheese++;
                }
            }
        }

        while (cheese != 0) {
            bfs();
        }

        System.out.println(result);
    }

    public static void bfs() {
        airSpace = new int[n][m];
        queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        airSpace[0][0] = -1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    airSpace[nx][ny]++;
                }

                if (arr[nx][ny] == 0 && airSpace[nx][ny] == 0) {
                    airSpace[nx][ny] = -1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (airSpace[i][j] >= 2) {
                    cheese--;
                    arr[i][j] = 0;
                }
            }
        }
        result++;
    }
}
