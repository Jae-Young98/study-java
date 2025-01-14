package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        while (true) {
            int min = n / l - ((l - 1) / 2);

            if (min < 0 || l > 100) {
                System.out.println(-1);
                return;
            }

            int sum = (min * 2 + l - 1) * l / 2;

            if (sum == n) {
                for (int i = 0; i < l; i++) {
                    System.out.print((min + i) + " ");
                }
                return;
            }
            l++;
        }
    }
}
