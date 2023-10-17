package BOJ.BarkingDogAlgorithm.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {

    static int N, M, result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(row, col, dir);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    public static void bfs(int x, int y, int dir) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, dir));
        arr[x][y] = 2;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            int cnt = 0;
            int nowX = p.x;
            int nowY = p.y;
            int nowD = p.dir;
            int nx, ny, nd;
            for (int i = 0; i < 4; i++) {
                nowD = (nowD + 3) % 4;
                nx = nowX + dx[nowD];
                ny = nowY + dy[nowD];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    queue.offer(new Point(nx, ny, nowD));
                    break;
                } else {
                    cnt++;
                }
            }

            if (cnt == 4) {
                nd = (nowD + 2) % 4;
                nx = nowX + dx[nd];
                ny = nowY + dy[nd];

                if (arr[nx][ny] != 1) {
                    arr[nx][ny] = 2;
                    queue.offer(new Point(nx, ny, nowD));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int dir;

        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
