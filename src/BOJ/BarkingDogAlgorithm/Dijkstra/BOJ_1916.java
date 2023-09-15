package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

    static int n, m, start, end;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node1>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // 인접리스트
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node1(v, w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(distance[end]);
    }

    public static void dijkstra() {
        PriorityQueue<Node1> queue = new PriorityQueue<>();
        queue.offer(new Node1(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node1 current = queue.poll();
            if (visited[current.edge]) {
                continue;
            }
            visited[current.edge] = true;
            for (int i = 0; i < list[current.edge].size(); i++) {
                Node1 next = list[current.edge].get(i);
                if (distance[next.edge] > distance[current.edge] + next.cost) {
                    distance[next.edge] = distance[current.edge] + next.cost;
                    queue.offer(new Node1(next.edge, distance[next.edge]));
                }
            }
        }
    }
}

class Node1 implements Comparable<Node1> {
    int edge;
    int cost;
    Node1(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node1 n) {
        return this.cost - n.cost;
    }
}