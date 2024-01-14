package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

    static int n;
    static int result;
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] visited;
    static PriorityQueue<Fish> pq = new PriorityQueue<>();

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        int eat = 0;
        while (true) {
            bfs();

            if (pq.isEmpty()) {
                break;
            }

            Fish fish = pq.poll();
            result += fish.distance;
            arr[fish.x][fish.y] = 0;
            sharkX = fish.x;
            sharkY = fish.y;
            eat++;
            if (sharkSize == eat) {
                sharkSize++;
                eat = 0;
            }
            pq.clear();
        }
        System.out.println(result);
    }

    public static void bfs() {
        Queue<Fish> queue = new LinkedList<>();
        queue.offer(new Fish(sharkX, sharkY, 0));

        visited = new int[n][n];

        while (!queue.isEmpty()) {
            Fish fish = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] == 0) {
                    if (arr[nx][ny] == sharkSize || arr[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        queue.offer(new Fish(nx, ny, fish.distance + 1));
                    } else if (arr[nx][ny] < sharkSize) {
                        visited[nx][ny] = 1;
                        pq.offer(new Fish(nx, ny, fish.distance + 1));
                    }
                }
            }
        }
    }
}
