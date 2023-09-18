package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp_6098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean answer = false;
        int position = 1;
        for (int i = 1; i < 9; i++) {
            for (int j = position; j < 9; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 9;
                }
                if (arr[i][j] == 2) {
                    arr[i][j] = 9;
                    answer = true;
                    break;
                }
                if (arr[i][j + 1] == 1) {
                    position = j;
                    break;
                }
            }
            if (answer) {
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
