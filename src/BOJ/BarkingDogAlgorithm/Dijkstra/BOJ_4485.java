package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {

    static int n;
    static int[][] arr;
    static int[][] loseCost;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int index = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                System.out.print(sb);
                return;
            }

            arr = new int[n][n];
            loseCost = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(loseCost[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            sb.append("Problem ").append(index).append(": ").append(loseCost[n - 1][n - 1]).append('\n');
            index++;
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        loseCost[0][0] = arr[0][0];
        visited[0][0] = true;
        pq.offer(new Node(0, 0, arr[0][0]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                int nCost = loseCost[node.x][node.y] + arr[nx][ny];
                if (loseCost[nx][ny] > nCost) {
                    loseCost[nx][ny] = nCost;
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, nCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
