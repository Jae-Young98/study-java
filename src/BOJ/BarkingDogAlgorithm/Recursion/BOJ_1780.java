package BOJ.BarkingDogAlgorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {

    static int arr[][];
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

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
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void partition(int row, int col, int size) {

        if (check(row, col, size)) {
            if (arr[row][col] == -1) {
                minusOne++;
            } else if (arr[row][col] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize); // 왼쪽 위
        partition(row, col + newSize, newSize); // 중앙 위
        partition(row, col + newSize * 2, newSize); // 오른쪽 위

        partition(row + newSize, col, newSize); // 왼쪽 중앙
        partition(row + newSize, col + newSize, newSize); // 중중
        partition(row + newSize, col + newSize * 2, newSize); // 오른쪽 중앙

        partition(row + newSize * 2, col, newSize);
        partition(row + newSize * 2, col + newSize, newSize);
        partition(row + newSize * 2, col + newSize * 2, newSize);
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
