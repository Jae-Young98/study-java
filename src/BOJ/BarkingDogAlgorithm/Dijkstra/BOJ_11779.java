package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779 {

    static int n, m, start, end;
    static int[] distance;
    static int[] route; // 경로 저장용 배열
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        route = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // 인접리스트 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(distance[end]);

        ArrayList<Integer> routes = new ArrayList<>();
        int c = end;
        while (c != 0) {
            routes.add(c);
            c = route[c];
        }
        // 도시 개수
        System.out.println(routes.size());
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;
        route[start] = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited[current.edge]) {
                continue;
            }
            visited[current.edge] = true;
            for (int i = 0; i < list[current.edge].size(); i++) {
                Node next = list[current.edge].get(i);
                if (distance[next.edge]  > distance[current.edge] + next.cost) {
                    distance[next.edge] = distance[current.edge] + next.cost;
                    queue.offer(new Node(next.edge, distance[next.edge]));
                    route[next.edge] = current.edge;
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int edge;
    int cost;
    Node(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}
