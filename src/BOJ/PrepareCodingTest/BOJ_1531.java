package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int leftTopX = Integer.parseInt(st.nextToken());
            int leftTopY = Integer.parseInt(st.nextToken());
            int rightBottomX = Integer.parseInt(st.nextToken());
            int rightBottomY = Integer.parseInt(st.nextToken());

            for (int j = leftTopY; j <= rightBottomY; j++) {
                for (int k = leftTopX; k <= rightBottomX; k++) {
                    arr[j][k]++;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] > m) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
