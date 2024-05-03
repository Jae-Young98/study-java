package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559 {

    static int[][] arr = new int[12][6];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Puyo> queue;
    static boolean isPop = false;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // R : 1, G : 2, B : 3, P : 4, Y : 5
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                char c = str.charAt(j);
                if (c == 'R') {
                    arr[i][j] = 1;
                } else if (c == 'G') {
                    arr[i][j] = 2;
                } else if (c == 'B') {
                    arr[i][j] = 3;
                } else if (c == 'P') {
                    arr[i][j] = 4;
                } else if (c == 'Y') {
                    arr[i][j] = 5;
                }
            }
        }

        while (true) {
            isPop = false;

            bfs();
            relocation();

            if (!isPop) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    public static void bfs() {
        queue = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    List<Point> list = new ArrayList<>();
                    queue.add(new Puyo(i, j, arr[i][j]));
                    list.add(new Point(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Puyo puyo = queue.poll();

                        for (int t = 0; t < 4; t++) {
                            int nx = puyo.x + dx[t];
                            int ny = puyo.y + dy[t];

                            if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) {
                                continue;
                            }

                            if (arr[nx][ny] == puyo.color && !visited[nx][ny]) {
                                queue.add(new Puyo(nx, ny, arr[nx][ny]));
                                list.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    if (list.size() >= 4) {
                        for (Point p : list) {
                            arr[p.x][p.y] = 0;

                            isPop = true;
                        }
                    }
                }
            }
        }
    }

    public static void relocation() {
        for (int i = 0; i < 6; i++) {
            queue = new LinkedList<>();

            for (int j = 11; j >= 0; j--) {
                if (arr[j][i] != 0) {
                    queue.add(new Puyo(j, i, arr[j][i]));
                    arr[j][i] = 0;
                }
            }

            int index = 11;
            while (!queue.isEmpty()) {
                Puyo puyo = queue.poll();

                arr[index][i] = puyo.color;
                index--;
            }
        }
    }

    public static class Puyo {

        int x;
        int y;
        int color;

        Puyo(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
