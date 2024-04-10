package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {

    static int N;
    static int[][] arr;
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // C = 1 (빨강), P = 2 (파랑), Z = 3 (초록), Y = 4 (노랑)
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            makeArr(i, str);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    checkArr();
                    swap(i, j + 1, i, j);
                }

                if (arr[i][j] != arr[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    checkArr();
                    swap(i + 1, j, i, j);
                }

                if (j == N - 2) {
                    swap(i, j + 1, i + 1, j + 1);
                    checkArr();
                    swap(i + 1, j + 1, i, j + 1);
                }
                checkArr();

                if (result == N) {
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static void makeArr(int i, String str) {
        for (int j = 0; j < N; j++) {
            char c = str.charAt(j);

            if (c == 'C') {
                arr[i][j] = 1;
            } else if (c == 'P') {
                arr[i][j] = 2;
            } else if (c == 'Z') {
                arr[i][j] = 3;
            } else {
                arr[i][j] = 4;
            }
        }
    }

    private static void swap(int i, int j, int nextI, int nextJ) {
        int tmp = arr[i][j];
        arr[i][j] = arr[nextI][nextJ];
        arr[nextI][nextJ] = tmp;
    }

    private static void checkArr() {
        for (int i = 0; i < N; i++) {
            int row = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    row++;
                    result = Math.max(result, row);
                } else {
                    row = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int col = 1;
            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    col++;
                    result = Math.max(result, col);
                } else {
                    col = 1;
                }
            }
        }
    }
}
