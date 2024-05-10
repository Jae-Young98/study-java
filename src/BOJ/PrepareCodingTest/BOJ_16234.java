package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static List<Point> list;
    static int n;
    static int l;
    static int r;
    static Queue<Point> queue = new LinkedList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean canMove = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            move(sum);
                            canMove = true;
                        }
                    }
                }
            }
            if (!canMove) {
                System.out.println(result);
                return;
            }
            result++;
        }
    }

    public static int bfs(int x, int y) {
        queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.offer(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;

        int sum = arr[x][y];
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                int difference = Math.abs(arr[p.x][p.y] - arr[nx][ny]);
                if (!visited[nx][ny] && difference >= l && difference <= r) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    list.add(new Point(nx, ny));
                    sum += arr[nx][ny];
                }
            }
        }
        return sum;
    }

    public static void move(int sum) {
        int people = sum / list.size();

        for (Point p : list) {
            arr[p.x][p.y] = people;
        }
    }
}
