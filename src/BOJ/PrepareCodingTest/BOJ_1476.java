package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        int e = 0;
        int s = 0;
        int m = 0;
        while (true) {
            e++;
            s++;
            m++;
            result++;

            if (e > 15) {
                e = 1;
            }
            if (s > 28) {
                s = 1;
            }
            if (m > 19) {
                m = 1;
            }

            if (e == E && s == S && m == M) {
                break;
            }
        }

        System.out.println(result);
    }
}
