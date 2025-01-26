package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4396 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] bombs = new char[n][n];
        char[][] arr = new char[n][n];
        boolean isOpen = false;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                bombs[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == 'x') {
                    if (bombs[i][j] == '*') {
                        isOpen = true;
                    } else {
                        int count = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n || bombs[nx][ny] != '*') {
                                continue;
                            }

                            count++;
                        }

                        arr[i][j] = (char) (count + '0');
                    }
                } else {
                    arr[i][j] = '.';
                }
            }
        }

        if (isOpen) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bombs[i][j] == '*') {
                        arr[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
