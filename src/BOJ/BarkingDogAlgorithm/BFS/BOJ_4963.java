package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

    static int w, h;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //3시, 5시, 6시, 7시, 9시, 11시, 12시, 1시
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        result++;
                    }
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
