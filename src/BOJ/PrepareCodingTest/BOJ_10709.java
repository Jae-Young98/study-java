package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10709 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(arr[i], -1);
        }

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = str.charAt(j);
                if (c == 'c') {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 0) {
                    for (int k = j + 1; k < w; k++) {
                        if (arr[i][k] == -1) {
                            arr[i][k] = arr[i][k - 1] + 1;
                        } else if (arr[i][k] > arr[i][k - 1] + 1) {
                            arr[i][k] = arr[i][k - 1] + 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
