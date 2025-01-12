package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18126 {

    static int n;
    static List<Node>[] list;
    static boolean[] visited;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.println(result);
    }

    static void dfs(int start, long dist) {
        if (result < dist) {
            result = dist;
        }

        for (Node node : list[start]) {
            if (visited[node.point]) {
                continue;
            }

            visited[node.point] = true;
            dfs(node.point, node.dist + dist);
        }
    }

    static class Node {

        int point;
        int dist;

        Node(int point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }
}
