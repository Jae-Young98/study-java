package BOJ.BarkingDogAlgorithm.BFS;

import javax.sound.sampled.Line;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int n, m, h;
    static int[][][] arr;
    // 우, 하, 좌, 상, 위, 아래
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.offer(new PointXYZ(i, j, k));
                    }
                }
            }
        }
        bfs();
    }
    public static void bfs() {
        while(!queue.isEmpty()) {
            PointXYZ p = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) {
                    continue;
                }
                if (arr[nz][nx][ny] == 0) {
                    queue.offer(new PointXYZ(nz, nx, ny));
                    arr[nz][nx][ny] = arr[p.z][p.x][p.y] + 1;
                }
            }
        }
        int day = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, arr[i][j][k]);
                }
            }
        }
        if (day == 1) {
            System.out.println(0);
        } else {
            System.out.println(day-1);
        }
    }
}

class PointXYZ {
    int x;
    int y;
    int z;

    PointXYZ(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
