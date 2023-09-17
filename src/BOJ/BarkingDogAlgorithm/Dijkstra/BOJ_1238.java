package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {

    static int n, m, x;
    static int[] distance1;
    static int[] distance2;
    static boolean[] visited;
    static ArrayList<Node4>[] list1;
    static ArrayList<Node4>[] list2;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list1 = new ArrayList[n + 1];
        list2 = new ArrayList[n + 1];
        distance1 = new int[n + 1];
        distance2 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 노드 -> 목적지
            list1[u].add(new Node4(v, w));
            // 목적지 -> 노드
            list2[v].add(new Node4(u, w));
        }

        distance1 = dijkstra(list1, distance1, x);
        distance2 = dijkstra(list2, distance2, x);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            result = Math.max(distance1[i] + distance2[i], result);
        }
        System.out.println(result);
    }

    public static int[] dijkstra(ArrayList<Node4>[] arr, int[] distance, int start) {
        Arrays.fill(distance, INF);
        visited = new boolean[n + 1];

        PriorityQueue<Node4> queue = new PriorityQueue<>();
        queue.offer(new Node4(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node4 current = queue.poll();
            if (visited[current.edge]) {
                continue;
            }
            visited[current.edge] = true;
            for (int i = 0; i < arr[current.edge].size(); i++) {
                Node4 next = arr[current.edge].get(i);
                if (distance[next.edge] > distance[current.edge] + next.cost) {
                    distance[next.edge] = distance[current.edge] + next.cost;
                    queue.offer(new Node4(next.edge, distance[next.edge]));
                }
            }
        }
        return distance;
    }
}

class Node4 implements Comparable<Node4> {
    int edge;
    int cost;

    Node4(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node4 n) {
        return this.cost - n.cost;
    }
}
