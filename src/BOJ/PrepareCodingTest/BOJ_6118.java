package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6118 {

    static int n, m;
    static List<Integer>[] list;
    static int num, distance, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        bfs(1);

        sb.append(num).append(' ').append(distance).append(' ').append(count).append('\n');
        System.out.print(sb);
    }

    public static void bfs(int start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, 0));

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.y > distance) {
                num = p.x;
                distance = p.y;
                count = 1;
            } else if (p.y == distance) {
                if (num > p.x) {
                    num = p.x;
                }
                count++;
            }

            for (int i : list[p.x]) {
                if (!visited[i]) {
                    queue.offer(new Point(i, p.y + 1));
                    visited[i] = true;
                }
            }
        }
    }
}
