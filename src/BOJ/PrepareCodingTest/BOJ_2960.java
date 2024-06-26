package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i; j <= n; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                    k--;

                    if (k == 0) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
