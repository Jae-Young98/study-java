package BOJ.BarkingDogAlgorithm.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String cmd;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cmd = st.nextToken();
            if (cmd.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.offerFirst(x);
            } else if (cmd.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.offerLast(x);
            } else if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.pollFirst()).append('\n');
                }
            } else if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.pollLast()).append('\n');
                }
            } else if (cmd.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (cmd.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if (cmd.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.peekFirst()).append('\n');
                }
            } else if (cmd.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.peekLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
