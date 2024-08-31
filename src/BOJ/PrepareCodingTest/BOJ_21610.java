package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610 {

    static int n, m, d, s;
    static int[][] arr;
    static Queue<Point> clouds = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Point(n - 1, 0));
        clouds.add(new Point(n - 1, 1));
        clouds.add(new Point(n - 2, 0));
        clouds.add(new Point(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());

            moveAndFill();
            removeAndBug();
            addCloudAndRemoveWater();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += arr[i][j];
            }
        }
        System.out.println(result);
    }

    static void moveAndFill() {
        for (Point p : clouds) {
            p.x = (n + p.x + dx[d] * (s % n)) % n;
            p.y = (n + p.y + dy[d] * (s % n)) % n;
            arr[p.x][p.y]++;
        }
    }

    static void removeAndBug() {
        while (!clouds.isEmpty()) {
            Point p = clouds.poll();
            int count = 0;

            visited[p.x][p.y] = true;
            for (int i = 1; i <= 7; i += 2) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (arr[nx][ny] >= 1) {
                    count++;
                }
            }
            arr[p.x][p.y] += count;
        }
    }

    static void addCloudAndRemoveWater() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] >= 2) {
                    arr[i][j] -= 2;
                    clouds.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[n][n];
    }
}
