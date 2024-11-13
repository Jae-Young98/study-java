package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10703 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Character[][] arr = new Character[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int meteor = -1;
            int land = -1;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 'X') {
                    meteor = j;
                } else if (arr[j][i] == '#') {
                    land = j;
                    break;
                }
            }

            if (meteor == -1) {
                continue;
            }

            if (land == -1) {
                land = n - 1;
            }

            min = Math.min(min, land - meteor - 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    arr[i + min][j] = 'X';
                    arr[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
