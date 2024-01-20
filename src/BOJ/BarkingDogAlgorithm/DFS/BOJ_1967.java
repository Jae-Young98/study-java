package BOJ.BarkingDogAlgorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967 {

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int result = 0;
    static int maxIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            tree[start].add(new Node(dest, distance));
            tree[dest].add(new Node(start, distance));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[maxIndex] = true;
        dfs(maxIndex, 0);

        System.out.println(result);
    }

    public static void dfs(int start, int weight) {
        if (result < weight) {
            result = weight;
            maxIndex = start;
        }

        for (Node node : tree[start]) {
            if (!visited[node.index]) {
                visited[node.index] = true;
                dfs(node.index, node.distance + weight);
            }
        }
    }

    public static class Node {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
