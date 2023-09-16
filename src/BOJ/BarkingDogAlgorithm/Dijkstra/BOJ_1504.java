package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {

    static int n, e;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node3>[] list;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // u -> v
            list[u].add(new Node3(v, w));
            // v -> e
            list[v].add(new Node3(u, w));
        }
        // 지나야 하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> n
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> n
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);

        int answer;
        if (result1 >= INF && result2 >= INF) {
            answer = -1;
        } else {
            answer = Math.min(result1, result2);
        }
        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        visited = new boolean[n + 1];

        PriorityQueue<Node3> queue = new PriorityQueue<>();
        queue.offer(new Node3(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node3 current = queue.poll();
            if (visited[current.edge]) {
                continue;
            }
            visited[current.edge] = true;
            for (int i = 0; i < list[current.edge].size(); i++) {
                Node3 next = list[current.edge].get(i);
                if (distance[next.edge] > distance[current.edge] + next.cost) {
                    distance[next.edge] = distance[current.edge] + next.cost;
                    queue.offer(new Node3(next.edge, distance[next.edge]));
                }
            }
        }
        return distance[end];
    }
}

class Node3 implements Comparable<Node3> {
    int edge;
    int cost;

    Node3(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node3 n) {
        return this.cost - n.cost;
    }
}
