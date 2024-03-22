package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {

    static int n, m;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra();

        System.out.println(dist[n]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.edge]) {
                continue;
            }

            visited[node.edge] = true;
            for (int i = 0; i < list[node.edge].size(); i++) {
                Node next = list[node.edge].get(i);
                if (dist[next.edge] > dist[node.edge] + next.cost) {
                    dist[next.edge] = dist[node.edge] + next.cost;
                    pq.offer(new Node(next.edge, dist[next.edge]));
                }
            }
        }
    }
    static class Node implements Comparable<Node> {

        int edge;
        int cost;

        Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
