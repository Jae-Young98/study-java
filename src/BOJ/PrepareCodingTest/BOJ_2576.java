package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x % 2 != 0) {
                sum += x;
                min = Math.min(min, x);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }
}
