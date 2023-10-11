package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean visited[] = new boolean[n + 1];
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        int result = bfs(adjList, visited, 1);
        System.out.println(result);
    }

    public static int bfs(LinkedList<Integer>[] list, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        int result = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            Iterator<Integer> iter = list[node].listIterator();
            while (iter.hasNext()) {
                int w = iter.next();
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                    result++;
                }
            }
        }
        return result;
    }
}
