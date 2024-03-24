package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            arr = new char[3][3];
            int xCount = 0;
            int oCount = 0;
            int index = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = str.charAt(index);
                    index++;

                    if (arr[i][j] == 'X') {
                        xCount++;
                    } else if (arr[i][j] == 'O') {
                        oCount++;
                    }
                }
            }
            // X의 개수 = O의 개수 + 1 (X 승)
            if (xCount == oCount + 1) {
                if (xCount + oCount == 9 && !isBingo('O')) {
                    sb.append("valid").append('\n');
                } else if (!isBingo('O') && isBingo('X')) {
                    sb.append("valid").append('\n');
                } else {
                    sb.append("invalid").append('\n');
                }
                // X의 개수 = O의 개수 (O 승)
            } else if (xCount == oCount) {
                if (!isBingo('X') && isBingo('O')) {
                    sb.append("valid").append('\n');
                } else {
                    sb.append("invalid").append('\n');
                }
            } else {
                sb.append("invalid").append('\n');
            }
        }
        System.out.print(sb);
    }

    public static boolean isBingo(char c) {
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) {
                return true;
            }

            if (arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) {
                return true;
            }
        }

        if (arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) {
            return true;
        }

        return arr[0][2] == c && arr[1][1] == c && arr[2][0] == c;
    }
}
