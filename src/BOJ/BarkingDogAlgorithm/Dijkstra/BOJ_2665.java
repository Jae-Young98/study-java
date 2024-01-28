package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2665 {

    static int[][] arr;
    static int[][] distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(distance[n - 1][n - 1]);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        distance[0][0] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (distance[nx][ny] > distance[p.x][p.y]) {
                    if (arr[nx][ny] == 1) {
                        distance[nx][ny] = distance[p.x][p.y];
                    } else {
                        distance[nx][ny] = distance[p.x][p.y] + 1;
                    }
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }
}
