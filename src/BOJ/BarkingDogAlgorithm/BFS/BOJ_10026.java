package BOJ.BarkingDogAlgorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    static int n;
    static char[][] notWeakArr;
    static char[][] weakArr;
    static boolean[][] notWeakVisit;
    static boolean[][] weakVisit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        notWeakArr = new char[n][n];
        weakArr = new char[n][n];
        notWeakVisit = new boolean[n][n];
        weakVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                notWeakArr[i][j] = str.charAt(j);
                weakArr[i][j] = str.charAt(j);
                if (weakArr[i][j] == 'G') {
                    weakArr[i][j] = 'R';
                }
            }
        }

        int notWeak = 0;
        int weak = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!notWeakVisit[i][j]) {
                    bfs(i, j, notWeakArr, notWeakVisit);
                    notWeak++;
                }
                if (!weakVisit[i][j]) {
                    bfs(i, j, weakArr, weakVisit);
                    weak++;
                }
            }
        }
        System.out.println(notWeak + " " + weak);
    }

    static void bfs(int x, int y, char[][] arr, boolean[][] visit) {
        visit[x][y] = true;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (arr[nx][ny] == arr[x][y] && !visit[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
