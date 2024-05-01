package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {

    static int n;
    static int m;
    static int x;
    static int y;
    static int[] dice = new int[6];
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1}; // 동 서 북 남
    static int[] dy = {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            roll(d - 1);
        }

        System.out.print(sb);
    }

    public static void roll(int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return;
        }

        int temp = dice[5];
        if (d == 0) {
            dice[5] = dice[2];
            dice[2] = dice[0];
            dice[0] = dice[3];
            dice[3] = temp;
        } else if (d == 1) {
            dice[5] = dice[3];
            dice[3] = dice[0];
            dice[0] = dice[2];
            dice[2] = temp;
        } else if (d == 2) {
            dice[5] = dice[4];
            dice[4] = dice[0];
            dice[0] = dice[1];
            dice[1] = temp;
        } else {
            dice[5] = dice[1];
            dice[1] = dice[0];
            dice[0] = dice[4];
            dice[4] = temp;
        }

        sb.append(dice[0]).append('\n');

        x = nx;
        y = ny;

        if (arr[x][y] == 0) {
            arr[x][y] = dice[5];
        } else {
            dice[5] = arr[x][y];
            arr[x][y] = 0;
        }
    }
}
