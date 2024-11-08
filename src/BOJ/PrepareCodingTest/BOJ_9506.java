package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9506 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();

            if (n == -1) {
                break;
            }

            sb.append(n).append(" = 1");
            int sum = 1;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    sb.append(" + ").append(i);
                    sum += i;
                }
            }

            if (sum == n) {
                System.out.println(sb);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
