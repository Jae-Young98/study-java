package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {

    static int T, n, d, c;
    static int count;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a, s));
            }

            count = 0;

            dist = new int[n + 1];
            visited = new boolean[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;
            dijkstra();

            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    max = Math.max(max, dist[i]);
                }
            }
            sb.append(count).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.edge]) {
                continue;
            }

            visited[node.edge] = true;
            count++;
            for (int i = 0; i < list[node.edge].size(); i++) {
                Node next = list[node.edge].get(i);
                if (dist[next.edge] > dist[node.edge] + next.cost) {
                    dist[next.edge] = dist[node.edge] + next.cost;
                    pq.offer(new Node(next.edge, dist[next.edge]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

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
