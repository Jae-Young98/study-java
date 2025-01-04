package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {

    static int n;
    static int k;
    static int[] arr = new int[100001];
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        sb.append(visited[k] - 1).append('\n');

        Stack<Integer> stack = new Stack<>();
        int index = k;
        while (index != n) {
            stack.push(index);
            index = arr[index];
        }
        stack.push(index);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                arr[now + 1] = now;
                queue.add(now + 1);
            }

            if (now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                arr[now - 1] = now;
                queue.add(now - 1);
            }

            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                visited[now * 2] = visited[now] + 1;
                arr[now * 2] = now;
                queue.add(now * 2);
            }

            if (visited[k] != 0) {
                return;
            }
        }
    }
}
