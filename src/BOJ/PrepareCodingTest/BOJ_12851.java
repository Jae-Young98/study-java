package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

    static int n;
    static int k;
    static int count = 0;
    static int fastestTime = Integer.MAX_VALUE;
    static int[] visit = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        } else {
            bfs();
        }

        sb.append(fastestTime).append('\n');
        sb.append(count).append('\n');
        System.out.print(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visit[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visit[now] > fastestTime) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = now - 1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = now * 2;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == k) {
                    fastestTime = visit[now];
                    count++;
                }

                if (visit[next] == 0 || visit[next] == visit[now] + 1) {
                    queue.offer(next);
                    visit[next] = visit[now] + 1;
                }
            }
        }
    }
}
