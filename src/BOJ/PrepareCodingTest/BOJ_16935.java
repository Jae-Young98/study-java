package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {

    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int c = Integer.parseInt(st.nextToken());
            rotate(c);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int command) {
        if (command == 1) {
            int[][] tempArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempArr[n - i - 1][j] = arr[i][j];
                }
            }
            arr = tempArr;
        }

        if (command == 2) {
            int[][] tempArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempArr[i][m - j - 1] = arr[i][j];
                }
            }
            arr = tempArr;
        }

        if (command == 3) {
            int[][] tempArr = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempArr[j][n - i - 1] = arr[i][j];
                }
            }

            // 배열 전환
            int tmp = n;
            n = m;
            m = tmp;

            arr = tempArr;
        }

        if (command == 4) {
            int[][] tempArr = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempArr[m - j - 1][i] = arr[i][j];
                }
            }
            // 배열 전환
            int tmp = n;
            n = m;
            m = tmp;

            arr = tempArr;
        }

        if (command == 5) {
            int[][] tempArr = new int[n][m];
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < m / 2; j++) {
                    tempArr[i][m / 2 + j] = arr[i][j];
                }
            }

            // 0,4 -> 3,4
            for(int i = 0; i < n / 2; i++){
                for(int j = m / 2; j < m; j++){
                    tempArr[n / 2 + i][j] = arr[i][j];
                }
            }
            // 3,4 -> 3,0
            for(int i = n / 2; i < n; i++){
                for(int j = m / 2; j < m; j++){
                    tempArr[i][j - m / 2] = arr[i][j];
                }
            }
            // 3,0 -> 0,0
            for(int i = n / 2; i < n; i++){
                for(int j = 0; j < m / 2; j++){
                    tempArr[i - n / 2][j] = arr[i][j];
                }
            }
            arr = tempArr;
        }

        if (command == 6) {
            int[][] tempArr = new int[n][m];
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < m / 2; j++) {
                    tempArr[n / 2 + i][j] = arr[i][j];
                }
            }

            // 3,0 -> 3,4
            for(int i = n / 2; i < n; i++){
                for(int j = 0; j < m / 2; j++){
                    tempArr[i][j + m / 2] = arr[i][j];
                }
            }
            // 3,4 -> 0,4
            for(int i = n / 2; i < n; i++){
                for(int j = m / 2; j < m; j++){
                    tempArr[i - n / 2][j] = arr[i][j];
                }
            }


            // 0,4 -> 0,0
            for(int i = 0; i < n / 2; i++){
                for(int j = m / 2; j < m; j++){
                    tempArr[i][j - m / 2] = arr[i][j];
                }
            }

            arr = tempArr;
        }
    }
}
