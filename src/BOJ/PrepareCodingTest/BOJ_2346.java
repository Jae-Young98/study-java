package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while (!deque.isEmpty()) {
            sb.append(deque.getFirst().num).append(' ');
            int val = deque.poll().val;

            if (deque.isEmpty()) {
                break;
            }

            if (val > 0) {
                for (int i = 0; i < val - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(val); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }

    static class Balloon {
        int num;
        int val;

        Balloon(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }
}
