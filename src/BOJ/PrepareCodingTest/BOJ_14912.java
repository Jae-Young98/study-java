package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x > 0) {
                if (x % 10 == d) {
                    result++;
                }
                x /= 10;
            }
        }

        System.out.println(result);
    }
}
