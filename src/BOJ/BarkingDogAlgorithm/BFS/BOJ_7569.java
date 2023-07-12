package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int n, m, h;
    static int day = 0;
    static int[][] arr;
    // 오른쪽, 오른쪽 아래, 아래, 왼쪽 아래, 왼쪽, 왼쪽 위, 위, 오른쪽 위 8방향
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[n*h][m];
            for (int j = 0; j < n*h; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    if (arr[j][k] == 1) {
                        queue.offer(new Point(j, k));
                    }
                }
            }
        bfs(arr, n*h, m);
    }

    public static void bfs(int[][] arr, int n, int m) {
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (arr[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                }
            }
        }
        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, arr[i][j]);
            }
        }
        System.out.println(day - 1);
    }
}

//  5 3 2
//  -1 -1 -1 -1 -1
//  -1 -1 -1 -1 -1
//  -1 -1 0 -1 -1
//  -1 -1 1 -1 -1
//  -1 -1 -1 -1 -1
//  -1 -1 -1 -1 -1
