package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1755 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dictionary = {8, 5, 4, 9, 1, 7, 6, 3, 2, 0};

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (dictionary[i] >= m && dictionary[i] <= n) {
                sb.append(dictionary[i]).append(' ');
                count++;

                if (count % 10 == 0) {
                    sb.append('\n');
                }
            }

            if (dictionary[i] * 10 >= m - 10) {
                for (int j = 0; j < 10; j++) {
                    int num = dictionary[i] * 10 + dictionary[j];

                    if (num < 10 || num < m || num > n) {
                        continue;
                    }

                    sb.append(num).append(' ');
                    count++;

                    if (count % 10 == 0) {
                        sb.append('\n');
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
