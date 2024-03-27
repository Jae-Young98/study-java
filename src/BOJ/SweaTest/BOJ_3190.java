package BOJ.SweaTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190 {

    static int n;
    static Map<Integer, String> map;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int apple = Integer.parseInt(br.readLine());

        // 1 = 뱀, 2 = 사과
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        for (int i = 0; i < apple; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 2;
        }

        int l = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            map.put(x, c);
        }
        bfs();
        System.out.println(time + 1);
    }

    public static void bfs() {
        Queue<Snake> queue = new LinkedList<>();
        Queue<Point> snakeTail = new LinkedList<>();
        queue.offer(new Snake(1, 1, 0));
        snakeTail.offer(new Point(1, 1));
        arr[1][1] = 1;
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Snake snake = queue.poll();
            int d = snake.d;

            if (map.containsKey(time)) {
                String direction = map.get(time);
                if (direction.equals("D")) {
                    d = getRightDirection(d);
                } else {
                    d = getLeftDirection(d);
                }
            }

            int nx = snake.x + dx[d];
            int ny = snake.y + dy[d];
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                break;
            }
            if (visited[nx][ny] || arr[nx][ny] == 1) {
                break;
            }

            if (arr[nx][ny] == 0) {
                arr[nx][ny] = 1;
                visited[nx][ny] = true;

                Point tail = snakeTail.poll();
                arr[tail.x][tail.y] = 0;
                visited[tail.x][tail.y] = false;
                queue.offer(new Snake(nx, ny, d));
                snakeTail.offer(new Point(nx, ny));
                time++;
            } else if (arr[nx][ny] == 2) {
                arr[nx][ny] = 1;
                visited[nx][ny] = true;
                queue.offer(new Snake(nx, ny, d));
                snakeTail.offer(new Point(nx, ny));
                time++;
            }
        }
    }

    public static int getRightDirection(int d) {
        if (d == 0) {
            return 1;
        } else if (d == 1) {
            return 2;
        } else if (d == 2) {
            return 3;
        } else {
            return 0;
        }
    }

    public static int getLeftDirection(int d) {
        if (d == 0) {
            return 3;
        } else if (d == 1) {
            return 0;
        } else if (d == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public static class Snake {
        int x;
        int y;
        int d;

        public Snake(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
