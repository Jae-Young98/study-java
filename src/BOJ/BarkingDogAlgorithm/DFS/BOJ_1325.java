package BOJ.BarkingDogAlgorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i : list[idx]) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
