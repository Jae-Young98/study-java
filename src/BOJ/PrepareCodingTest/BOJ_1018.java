package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {

    static char[][] arr;
    static int n, m;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(i, j);
            }
        }
        System.out.println(result);
    }

    public static void find(int x, int y) {
        int count = 0;

        char color = arr[x][y];
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i][j] != color) {
                    count++;
                }

                if (color == 'W') {
                    color = 'B';
                } else {
                    color = 'W';
                }
            }

            if (color == 'W') {
                color = 'B';
            } else {
                color = 'W';
            }
        }

        // 흰, 검 어느 색을 뒤집을지
        count = Math.min(count, 64 - count);
        result = Math.min(result, count);
    }
}
