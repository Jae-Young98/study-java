package BOJ.BarkingDogAlgorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] visited;
    static int n, m, r;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        result = 1;
        dfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int node) {
        visited[node] = result;

        for (int i = 0; i < list.get(node).size(); i++) {
            int dest = list.get(node).get(i);
            if (visited[dest] == 0) {
                result++;
                dfs(dest);
            }
        }
    }
}
