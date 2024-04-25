package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {

    static int[][] gear;
    static int[][] turnArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gear = new int[5][9];
        for (int i = 1; i <= 4; i++) {
            String wheel = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = wheel.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine()); // 회전 횟수
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            checkDir(number, direction);
            turn();
        }

        int result = 0;
        int x = 1;
        for (int i = 1; i <= 4; i++) {
            result += gear[i][0] * x;
            x *= 2;
        }

        System.out.println(result);
    }

    public static void checkDir(int number, int direction) {
        turnArr = new int[5][1];
        turnArr[number][0] = direction;
        for (int i = number - 1; i >= 1; i--) {
            if (gear[i + 1][6] != gear[i][2]) {
                turnArr[i][0] = turnArr[i + 1][0] * -1;
            } else {
                break;
            }
        }

        for (int i = number + 1; i <= 4; i++) {
            if (gear[i - 1][2] != gear[i][6]) {
                turnArr[i][0] = turnArr[i - 1][0] * -1;
            } else {
                break;
            }
        }
    }

    public static void turn() {
        for (int i = 1; i <= 4; i++) {
            if (turnArr[i][0] == -1) {
                int tmp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = tmp;
            } else if (turnArr[i][0] == 1) {
                int tmp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = tmp;
            }
        }
    }
}
