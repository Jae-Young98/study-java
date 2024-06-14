package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        while (!queue.isEmpty()) {
            if (queue.peek() == idx) {
                queue.poll();
                idx++;
            } else if (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop();
                idx++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == idx) {
                stack.pop();
                idx++;
            } else {
                break;
            }
        }

        if (queue.isEmpty() && stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
