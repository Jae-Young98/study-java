package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    static int n;
    static int k;
    static int result = Integer.MAX_VALUE;
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        } else {
            bfs();
        }

        System.out.println(result);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visit[now.x] = true;

            if (now.x == k) {
                result = Math.min(result, now.time);
            }

            if (now.x * 2 < visit.length && !visit[now.x * 2]) {
                queue.offer(new Node(now.x * 2, now.time));
            }

            if (now.x + 1 < visit.length && !visit[now.x + 1]) {
                queue.offer(new Node(now.x + 1, now.time + 1));
            }

            if (now.x - 1 >= 0 && !visit[now.x - 1]) {
                queue.offer(new Node(now.x - 1, now.time + 1));
            }
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
