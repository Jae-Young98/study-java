package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24483 {

    static int n;
    static int m;
    static int r;
    static List<Integer>[] list;
    static int[] visited;
    static int[] arr;
    static long result = 0;
    static int node = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visited = new int[n + 1];
        arr = new int[n + 1];
        Arrays.fill(visited, -1);
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            list[i].sort(Comparator.comparingInt(o -> o));
        }

        dfs(r, 0);

        System.out.println(result);
    }

    static void dfs(int start, int depth) {
        visited[start] = depth;
        node++;
        arr[start] = node;
        result += (long) arr[start] * depth;
        for (int i : list[start]) {
            if (visited[i] == -1) {
                dfs(i, depth + 1);
            }
        }
    }
}
