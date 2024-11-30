package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;

        int[] depth = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            depth[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list.get(a).add(b);
            list.get(b).add(a);
        }

        depth[r] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < list.get(num).size(); i++) {
                int x = list.get(num).get(i);
                if (depth[x] == -1) {
                    depth[x] = depth[num] + 1;
                    queue.add(x);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(depth[i]);
        }
    }
}
