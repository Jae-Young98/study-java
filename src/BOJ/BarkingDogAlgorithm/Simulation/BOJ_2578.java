package BOJ.BarkingDogAlgorithm.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {

    static int[][] arr = new int[5][5];
    static int result;
    static int bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                result++;
                callNum(Integer.parseInt(st.nextToken()));
                isBingo();
                if (bingo >= 3) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }

    public static void callNum(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[i][j] == n) {
                    arr[i][j] = -1;
                    break;
                }
            }
        }
    }

    public static void isBingo() {
        bingo = 0;
        int x;
        int y;
        int xy = 0;
        int yx = 0;
        int point = 0;

        for (int i = 0; i < 5; i++) {
            x = 0;
            y = 0;
            for (int j = 0; j < 5; j++) {
                x += arr[i][j];
                y += arr[j][i];

                // 오른쪽 아래 대각선
                if (i == j) {
                    xy += arr[i][j];
                }
                // 왼쪽 아래 대각선
                if (i == point && j == 4 - point) {
                    yx += arr[i][j];
                    point++;
                }
            }
            if (x == -5) {
                bingo++;
            }
            if (y == -5) {
                bingo++;
            }
            if (xy == -5) {
                bingo++;
            }
            if (yx == -5) {
                bingo++;
            }
        }
    }
}
