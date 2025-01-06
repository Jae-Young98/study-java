package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_13417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Deque<String> dq = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            dq.push(st.nextToken());
            for (int i = 0; i < n - 1; i++) {
                String c = st.nextToken();

                if (dq.size() == 1) {
                    if (c.compareTo(dq.peek()) < 0) {
                        dq.addFirst(c);
                    } else if (c.compareTo(dq.peek()) == 0) {
                        dq.addLast(c);
                    } else {
                        dq.addLast(c);
                    }
                } else {
                    if (c.compareTo(dq.getFirst()) < 0) {
                        dq.addFirst(c);
                    } else if (c.compareTo(dq.getFirst()) == 0) {
                        dq.addFirst(c);
                    } else {
                        dq.addLast(c);
                    }
                }
            }

            while (!dq.isEmpty()) {
                sb.append(dq.removeFirst());
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
