package BOJ.BarkingDogAlgorithm.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13418 {

    static int[] parent;
    static int n, m;
    static PriorityQueue<node> worstQueue;
    static PriorityQueue<node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        worstQueue = new PriorityQueue<>();
        queue = new PriorityQueue<>(Collections.reverseOrder());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            worstQueue.add(new node(s, e, v));
            queue.add(new node(s, e, v));
        }

        // 최악의 경우
        int worstUphill = mst(worstQueue);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 최적의 경우
        int uphill = mst(queue);

        int result = (int) (Math.pow(worstUphill, 2) - Math.pow(uphill, 2));
        System.out.println(result);
    }

    public static int mst(PriorityQueue<node> queue) {
        int cost = 0;

        while (!queue.isEmpty()) {
            node now = queue.poll();

            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);

                if (now.v == 0) {
                    cost++;
                }
            }
        }
        return cost;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class node implements Comparable<node> {
        int s;
        int e;
        int v;

        node(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        public int compareTo(node o) {
            return this.v - o.v;
        }
    }
}
