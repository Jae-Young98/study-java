package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1652 {

    static int n;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][n];
        int row = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.' && !visited[i][j]) {
                    row += checkRow(i, j, visited);
                }
            }
        }

        visited = new boolean[n][n];
        int col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.' && !visited[i][j]) {
                    col += checkCol(i, j, visited);
                }
            }
        }

        System.out.print(row + " " + col + '\n');
    }

    public static int checkRow(int i, int j, boolean[][] visited) {
        int count = 0;
        for (int x = j; x < n; x++) {
            if (arr[i][x] == '.' && !visited[i][x]) {
                count++;
                visited[i][x] = true;
            } else if (arr[i][x] == 'X') {
                break;
            }
        }

        if (count >= 2) {
            return 1;
        }
        return 0;
    }

    public static int checkCol(int i, int j, boolean[][] visited) {
        int count = 0;
        for (int y = i; y < n; y++) {
            if (arr[y][j] == '.' && !visited[y][j]) {
                count++;
                visited[y][j] = true;
            } else if (arr[y][j] == 'X') {
                break;
            }
        }

        if (count >= 2) {
            return 1;
        }
        return 0;
    }
}
