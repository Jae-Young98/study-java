package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13901 {

    static int[] dx = {0, -1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[r][c];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1; // 장애물
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        arr[sr][sc] = 1; // 시작 위치

        int[] dir = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        int d = 0;
        int count = 0;
        while (true) {
            int nr = sr + dx[dir[d]];
            int nc = sc + dy[dir[d]];

            if (nr < 0 || nr >= r || nc < 0 || nc >= c || arr[nr][nc] == 1) {
                d = (d + 1) % 4;
                count++;
            } else {
                arr[nr][nc] = 1;
                sr = nr;
                sc = nc;
                count = 0;
            }

            if (count == 4) {
                break;
            }
        }

        System.out.println(sr + " " + sc);
    }
}
