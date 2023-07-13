package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static int t, n, x, y, mx, my;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visit = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            queue.offer(new Point(x, y));

            st = new StringTokenizer(br.readLine());
            mx = Integer.parseInt(st.nextToken());
            my = Integer.parseInt(st.nextToken());

            bfs();
            if (i == t-1) {
                sb.append(arr[mx][my]);
            } else {
                sb.append(arr[mx][my]).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void bfs() {
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (arr[nx][ny] == 0 && !visit[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                    if (nx == mx && ny == my) {
                        break;
                    }
                }
            }
        }
    }
}
