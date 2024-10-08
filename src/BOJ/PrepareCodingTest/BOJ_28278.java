package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (command == 2) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if (command == 3) {
                sb.append(stack.size()).append('\n');
            } else if (command == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
