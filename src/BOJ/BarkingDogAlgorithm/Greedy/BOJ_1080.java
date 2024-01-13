package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080 {

    static int n, m;
    static int[][] arrA;
    static int[][] arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrA = new int[n][m];
        arrB = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arrA[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arrB[i][j]  = str.charAt(j) - '0';
            }
        }

        if (n < 3 || m < 3) {
            if (canChange()) {
                System.out.println(0);
                return;
            } else {
                System.out.println(-1);
                return;
            }
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    flip(i, j);
                    count++;
                }
            }
        }

        if (canChange()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arrA[i][j] == 1) {
                    arrA[i][j] = 0;
                } else {
                    arrA[i][j] = 1;
                }
            }
        }
    }

    static boolean canChange() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
