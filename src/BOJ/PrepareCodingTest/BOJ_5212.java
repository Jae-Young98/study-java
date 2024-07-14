package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5212 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static char[][] arr;

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

        int u = n;
        int d = 0;
        int l = m;
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (arr[nx][ny] == '.') {
                                cnt++;
                            }
                        } else {
                            cnt++;
                        }
                    }

                    if (cnt >= 3) {
                        arr[i][j] = 'D';
                    }
                }
                if (arr[i][j] == 'X') {
                    u = Math.min(u, i);
                    d = Math.max(d, i);
                    l = Math.min(l, j);
                    r = Math.max(r, j);
                }
            }
        }

        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                char c = arr[i][j];
                if (c == 'X') {
                    System.out.print(c);
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
