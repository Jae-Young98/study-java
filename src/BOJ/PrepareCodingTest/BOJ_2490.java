package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 0 == 배, 1 == 등
        for (int i = 0; i < 3; i++) {
            int front = 0;
            int back = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) {
                    front++;
                } else {
                    back++;
                }
            }

            if (front == 1) {
                sb.append("A");
            } else if (front == 2) {
                sb.append("B");
            } else if (front == 3) {
                sb.append("C");
            } else if (front == 4) {
                sb.append("D");
            } else {
                sb.append("E");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
