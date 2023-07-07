package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int n, m;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 한 지점에서 시작하는게 아니므로 arr[i][j]가 1이면 큐에 삽입
                if (arr[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        bfs(arr, n, m);
    }

    public static void bfs(int[][] arr, int n, int m) {
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                // 익지 않은 토마토면 삽입
                if (arr[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                }
            }
        }
        // 일수 확인용 출력
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------");
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
        System.out.println(day-1);
    }
}
