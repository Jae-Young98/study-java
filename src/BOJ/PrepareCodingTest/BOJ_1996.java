package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1996 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int n;
    static boolean[][] mine;
    static char[][] arr;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        mine = new boolean[n][n];
        arr = new char[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                arr[i][j] = c;

                if (c != '.') {
                    mine[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != '.') {
                    int count = Integer.parseInt(String.valueOf(arr[i][j]));
                    deploy(i, j, count);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != '.') {
                    sb.append('*');
                } else if (map[i][j] >= 10) {
                    sb.append('M');
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void deploy(int x, int y, int count) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || mine[nx][ny]) {
                continue;
            }

            map[nx][ny] += count;
        }
    }
}
