package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // 0 == queue, 1 == stack
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (list.get(i) == 0) {
                dq.addLast(x);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dq.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
