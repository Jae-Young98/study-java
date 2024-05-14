package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                System.out.print(sb);
                return;
            }

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(br.readLine());
            }

            int l = 0;
            int r = 0;
            int result = 0;
            while (l != n && r != m) {
                if (a[l] == b[r]) {
                    result++;
                    l++;
                    r++;
                } else if (a[l] > b[r]) {
                    r++;
                } else {
                    l++;
                }
            }
            sb.append(result).append('\n');
        }
    }
}
