package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24482 {

    static int n;
    static int m;
    static int r;
    static List<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
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
            list[i].sort((o1, o2) -> o2 - o1);
        }

        Arrays.fill(visited, -1);
        visited[r] = 0;
        dfs(r, 0);

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    static void dfs(int start, int depth) {
        visited[start] = depth;

        for (int i : list[start]) {
            if (visited[i] != -1) {
                continue;
            }

            dfs(i, depth + 1);
        }
    }
}
