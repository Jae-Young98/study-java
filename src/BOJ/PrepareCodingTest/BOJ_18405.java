package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18405 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static Queue<Virus> queue = new LinkedList<>();
    static int n;
    static int k;
    static int s;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number != 0) {
                    queue.add(new Virus(number, i, j, 0));
                }
                arr[i][j] = number;
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(arr[x - 1][y - 1]);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Virus v = queue.poll();

            if (v.time == s) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = v.num;
                    queue.add(new Virus(v.num, nx, ny, v.time + 1));
                }
            }
        }
    }

    static class Virus implements Comparable<Virus> {
        int num;
        int x;
        int y;
        int time;

        Virus(int num, int x, int y, int time) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return this.num - o.num;
        }
    }
}
