package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int m;
        int n;
        int x;
        int y;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // k % m = x, k % n = y

            // k의 최대는 m, n의 최소 공배수
            int lcm = m * n / GCD(m, n);

            x--;
            y--;
            int k = x;
            while (k <= lcm) {
                if (k % n == y) {
                    sb.append(k + 1).append('\n');
                    break;
                }
                k += m;
            }

            if (k > lcm) {
                sb.append(-1).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}
