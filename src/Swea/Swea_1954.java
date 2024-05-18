package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int dir = 0;
            int nowX = 0;
            int nowY = 0;

            for (int i = 1; i <= n * n; i++) {
                arr[nowX][nowY] = i;
                if (nowX + dx[dir] < 0 || nowX + dx[dir] >= n || nowY + dy[dir] < 0 || nowY + dy[dir] >= n
                || arr[nowX + dx[dir]][nowY + dy[dir]] != 0) {
                    dir = (dir + 1) % 4;
                }
                nowX += dx[dir];
                nowY += dy[dir];
            }

            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
