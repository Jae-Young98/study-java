package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1524 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int sejun = 0;
            int sebi = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int sj = Integer.parseInt(st.nextToken());
                sejun = Math.max(sejun, sj);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int seb = Integer.parseInt(st.nextToken());
                sebi = Math.max(sebi, seb);
            }

            if (sejun >= sebi) {
                sb.append("S");
            } else {
                sb.append("B");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
