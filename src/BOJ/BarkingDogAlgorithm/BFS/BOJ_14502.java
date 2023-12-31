package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

    static int n, m;
    static int max = 0;
    static int[][] arr;
    static int[][] copyArr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

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
        makeWall(0);
        System.out.println(max);
    }

    public static void makeWall(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        copyArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyArr[i][j] = arr[i][j];
                if (copyArr[i][j] == 2) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (copyArr[nx][ny] == 0) {
                    copyArr[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }
}
