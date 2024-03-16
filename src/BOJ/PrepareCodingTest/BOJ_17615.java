package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int result = Integer.MAX_VALUE;

        int red = 0;
        int blue = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') {
                red++;
            } else {
                blue++;
            }
        }

        // R을 모두 왼쪽으로
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, red - count);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, red - count);

        count = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, blue - count);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, blue - count);

        System.out.println(result);
    }
}
