package BOJ.BarkingDogAlgorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

    static int arr[][];
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (arr[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
