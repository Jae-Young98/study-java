package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2468 {
    static int n;
    static int max = 0;
    static int cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        // 높이 별로 안전영역 탐색
        for (int h = 0; h <= max; h++) {
            cnt = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            list.add(cnt);
        }
        max = 0;
        for (int i : list) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

    public static void bfs(int x, int y, int h) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < n && nx >= 0 && ny < n && ny >= 0) {
                    // 방문 하지 않고, 잠기는 높이보다 위일 경우
                    if (!visited[nx][ny] && arr[nx][ny] > h) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
