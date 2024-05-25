package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24444 {

    static int n, m, r;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        bfs();

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int visitNumber = 1;

        queue.offer(r);
        visited[r] = visitNumber;
        visitNumber++;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < list.get(x).size(); i++) {
                int nx = list.get(x).get(i);

                if (visited[nx] != 0) {
                    continue;
                }

                queue.offer(nx);
                visited[nx] = visitNumber;
                visitNumber++;
            }
        }
    }
}
