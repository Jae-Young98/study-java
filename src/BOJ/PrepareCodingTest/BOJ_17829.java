package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829 {

    static int[][] arr;

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

        System.out.println(recursive(0, 0, n));
    }

    static int recursive(int i, int j, int size) {
        if (size == 2) {
            int[] tmp = new int[4];
            int index = 0;

            for (int r = i; r < i + 2; r++) {
                for (int c = j; c < j + 2; c++) {
                    tmp[index] = arr[r][c];
                    index++;
                }
            }

            Arrays.sort(tmp);
            return tmp[2];
        } else {
            int[] tmp = new int[4];
            size /= 2;

            tmp[0] = recursive(i, j, size);
            tmp[1] = recursive(i, j + size, size);
            tmp[2] = recursive(i + size, j, size);
            tmp[3] = recursive(i + size, j + size, size);

            Arrays.sort(tmp);
            return tmp[2];
        }
    }
}
