package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12605 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<String> stack;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append("Case #").append(i).append(": ");
            st = new StringTokenizer(br.readLine());
            stack = new Stack<>();
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
