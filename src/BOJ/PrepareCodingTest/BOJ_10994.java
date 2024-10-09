package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10994 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int size = 4 * n - 3;
        arr = new char[size][size];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = idx; j < size - idx; j++) {
                // 사각형 맨 윗줄
                arr[idx][j] = '*';
                // 맨 아랫줄
                arr[size - idx - 1][j] = '*';
                // 맨 왼쪽줄
                arr[j][idx] = '*';
                // 오른쪽줄
                arr[j][size - idx - 1] = '*';
            }
            idx += 2;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == '*') {
                    sb.append(arr[i][j]);
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
