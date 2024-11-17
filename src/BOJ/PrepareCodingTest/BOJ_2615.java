package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2615 {

    static int[] dx = {-1, 0, 1, 1}; // 1시, 3시, 5시, 6시
    static int[] dy = {1, 1, 1, 0};
    static int[][] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] == 1) {
                    int result = check(i, j, 1);

                    if (result == 1) {
                        sb.append(1).append('\n').append(i + 1).append(' ').append(j + 1);
                        System.out.println(sb);
                        return;
                    }
                } else if (arr[i][j] == 2) {
                    int result = check(i, j, 2);

                    if (result == 2) {
                        sb.append(2).append('\n').append(i + 1).append(' ').append(j + 1);
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static int check(int x, int y, int color) {
        Queue<Point> queue;

        for (int i = 0; i < 4; i++) {
            queue = new LinkedList<>();
            queue.offer(new Point(x, y));
            count = 1;

            int lastX = x;
            int lastY = y;
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                lastX = p.x;
                lastY = p.y;

                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
                    continue;
                }

                if (arr[nx][ny] == color) {
                    count++;
                    queue.offer(new Point(nx, ny));
                }

                if (count > 5) {
                    break;
                }
            }

            if (count == 5) {
                return checkRever(lastX, lastY, color, i);
            }
        }

        return 0;
    }

    static int checkRever(int x, int y, int color, int dir) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int cnt = 1;

        int reverseDx = dx[dir] * -1;
        int reverseDy = dy[dir] * -1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int nx = p.x + reverseDx;
            int ny = p.y + reverseDy;
            if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
                continue;
            }

            if (arr[nx][ny] == color) {
                cnt++;
                queue.offer(new Point(nx, ny));
            }

            if (cnt > 5) {
                return 0;
            }
        }

        if (cnt == 5) {
            return color;
        }

        return 0;
    }
}
