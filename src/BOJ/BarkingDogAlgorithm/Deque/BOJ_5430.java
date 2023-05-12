package BOJ.BarkingDogAlgorithm.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(cmd, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String cmd, Deque<Integer> deque) {
        boolean isReverse = false;

        for (char c : cmd.toCharArray()) {
            if (c == 'R') {
                isReverse = !isReverse;
                continue;
            }

            if (isReverse) {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        PrintResult(deque, isReverse);
    }

    public static void PrintResult(Deque<Integer> deque, boolean isReverse) {
        sb.append('[');

        if (deque.size() > 0) {
            if (isReverse) {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }
        sb.append(']').append('\n');
    }

}
