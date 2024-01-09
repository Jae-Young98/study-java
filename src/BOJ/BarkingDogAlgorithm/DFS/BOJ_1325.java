package BOJ.BarkingDogAlgorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1325 {

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i);
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

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < list.get(node).size(); i++) {
            int dest = list.get(node).get(i);
            if (!visited[dest]) {
                result[dest]++;
                dfs(dest);
            }
        }
    }
}
