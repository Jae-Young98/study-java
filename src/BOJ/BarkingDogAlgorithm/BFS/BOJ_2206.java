package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    public static class Move {
        int x;
        int y;
        int cnt; // 이동
        boolean destroyed; // 부쉈는지

        Move(int x, int y, int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }

    static int n, m, result;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = ((int) str.charAt(j) - '0');
            }
        }
        bfs();
    }

    public static void bfs() {
        Queue<Move> queue = new LinkedList<>();

        queue.offer(new Move(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Move mv = queue.poll();

            if (mv.x == n-1 && mv.y == m-1) {
                System.out.println(mv.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = mv.x + dx[i];
                int ny = mv.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 0) {
                        if (!mv.destroyed && !visited[nx][ny][0]) {
                            queue.offer(new Move(nx, ny, mv.cnt + 1, false));
                            visited[nx][ny][0] = true;
                        } else if (mv.destroyed && !visited[nx][ny][1]) {
                            queue.offer(new Move(nx, ny, mv.cnt + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    } else if (arr[nx][ny] == 1) {
                        if (!mv.destroyed) {
                            queue.offer(new Move(nx, ny, mv.cnt + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
