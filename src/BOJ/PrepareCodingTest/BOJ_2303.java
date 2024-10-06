package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][1];
        for (int i = 1; i <= n; i++) {
            int[] card = new int[5];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                card[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = x + 1; y < 4; y++) {
                    for (int z = y + 1; z < 5; z++) {
                        int sum = card[x] + card[y] + card[z];
                        int num = sum % 10;
                        max = Math.max(max, num);

                        if (num == 9) {
                            break;
                        }
                    }
                }
            }
            arr[i][0] = max;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            if (arr[i][0] >= arr[result][0]) {
                result = i;
            }
        }

        System.out.println(result);
    }
}
