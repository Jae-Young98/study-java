package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        st = new StringTokenizer(sb.append(br.readLine()).reverse().toString());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 1) {
                dq.addFirst(i);
            } else if (x == 2) {
                int tmp = dq.removeFirst();
                dq.addFirst(i);
                dq.addFirst(tmp);
            } else {
                dq.addLast(i);
            }
        }

        sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(' ');
        }
        System.out.println(sb);
    }
}
