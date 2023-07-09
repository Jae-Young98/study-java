package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int t, n, m, k;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        // 테스트 케이스 진행
        for (int c = 0; c < t; c++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visit = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visit[i][j]) {
                        bfs(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);
            // printArr();
        }
    }

    static void bfs(int x, int y) {
        visit[x][y] = true;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    continue;
                }
                if (arr[xx][yy] == 1 && !visit[xx][yy]) {
                    queue.offer(new Point(xx, yy));
                    visit[xx][yy] = true;
                }
            }
        }
    }

    // 배열 출력
//    static void printArr() {
//        System.out.println("--------배열---------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("---------------------");
//    }
}
