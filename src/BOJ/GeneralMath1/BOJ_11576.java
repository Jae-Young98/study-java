package BOJ.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        long ten = 0;
        int pow = m - 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ten += Integer.parseInt(st.nextToken()) * (Math.pow(A, pow));
            pow--;
        }

        for (int i = 0; i < m; i++) {
            long b = ten % B;
            if (i == 0 && b == 0) {
                continue;
            }
            ten /= B;
            sb.append(" ").append(b);
        }
        System.out.println(sb.reverse());
    }
}
