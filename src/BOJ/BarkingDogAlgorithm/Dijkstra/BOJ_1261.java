package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {

    static int n, m;
    static int[][] arr;
    static int[][] distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        dijkstra();
        System.out.println(distance[n-1][m-1]);
    }

    public static void dijkstra() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        distance[0][0] = 0;
        queue.offer(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nCost = p.cost;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (arr[nx][ny] == 1) {
                    nCost++;
                }
                if (distance[nx][ny] > nCost) {
                    distance[nx][ny] = nCost;
                    queue.offer(new Point(nx, ny, nCost));
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point p) {
            return this.cost - p.cost;
        }
    }
}
