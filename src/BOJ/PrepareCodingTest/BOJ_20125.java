package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int heartX = 0;
        int heartY = 0;
        boolean isHead = false;

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= n; j++) {
                char c = str.charAt(j - 1);
                if (c == '*') {
                    arr[i][j] = 1;
                    if (!isHead) {
                        isHead = true;
                        heartX = i + 1;
                        heartY = j;
                        sb.append(heartX).append(" ").append(heartY).append('\n');
                    }
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int legPoint = 0;

        for (int i = heartY - 1; i > 0; i--) {
            if (arr[heartX][i] == 1) {
                leftArm++;
            } else {
                break;
            }
        }

        for (int i = heartY + 1; i <= n; i++) {
            if (arr[heartX][i] == 1) {
                rightArm++;
            } else {
                break;
            }
        }

        for (int i = heartX + 1; i <= n; i++) {
            if (arr[i][heartY] == 1) {
                waist++;
            } else {
                legPoint = i;
                break;
            }
        }

        for (int i = legPoint; i <= n; i++) {
            if (arr[i][heartY - 1] == 1) {
                leftLeg++;
            } else {
                break;
            }
        }

        for (int i = legPoint; i <= n; i++) {
            if (arr[i][heartY + 1] == 1) {
                rightLeg++;
            } else {
                break;
            }
        }

        sb.append(leftArm).append(" ").append(rightArm)
                .append(" ").append(waist)
                .append(" ").append(leftLeg).append(" ").append(rightLeg);

        System.out.println(sb);
    }
}
