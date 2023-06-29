package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        // 오른쪽, 아래, 왼쪽, 위
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 배열 세팅
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 0 이거나 방문 했던 곳이면 패스
                if (arr[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                count++;
                queue.offer(new Point(i, j)); // java.awt.Point 클래스 활용
                visit[i][j] = true;
                area = 0;
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    area++;
                    for (int k = 0; k < 4; k++) {
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            continue;
                        }
                        if (arr[x][y] == 1 && !visit[x][y]) {
                            queue.offer(new Point(x, y));
                            visit[x][y] = true;
                        }
                    }
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }
}
