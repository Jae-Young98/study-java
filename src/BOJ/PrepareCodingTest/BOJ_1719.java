package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1719 {

    static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int n, m;
    static List<Node>[] list;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + 1]; // 집하장 간의 경로
        result = new int[n][n]; // 경로표

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] arr = new int[n + 1]; // 최단 경로

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        arr[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (arr[now.v] < now.cost) {
                continue;
            }

            if (!visited[now.v]) {
                visited[now.v] = true;
            }

            for (Node node : list[now.v]) {
                // 다음 방문할 정점에 방문하지 않았고 최단 경로라면
                if (!visited[node.v] && now.cost + node.cost < arr[node.v]) {
                    arr[node.v] = now.cost + node.cost;
                    result[node.v - 1][start - 1] = now.v;
                    pq.add(new Node(node.v, arr[node.v]));
                }
            }
        }
    }
}
