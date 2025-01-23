package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int value = 1;
        int level = 1;
        int x = n / 2;
        int y = n / 2;
        
        while (true) {
            for (int i = 0; i < level; i++) {
                arr[x][y] = value;
                value++;
                x--;
            }

            if ((value - 1) == n * n) {
                break;
            }

            for (int i = 0; i < level; i++) {
                arr[x][y] = value;
                value++;
                y++;
            }
            level++;

            for (int i = 0; i < level; i++) {
                arr[x][y] = value;
                value++;
                x++;
            }

            for (int i = 0; i < level; i++) {
                arr[x][y] = value;
                value++;
                y--;
            }
            level++;
        }

        int resultX = 0;
        int resultY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(' ');
                if (arr[i][j] == num) {
                    resultX = i + 1;
                    resultY = j + 1;
                }
            }
            sb.append('\n');
        }
        sb.append(resultX).append(' ').append(resultY);
        System.out.println(sb);
    }
}
