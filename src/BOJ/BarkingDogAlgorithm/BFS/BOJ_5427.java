package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;
    int cnt;

    Position(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_5427 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M, result;
    static boolean[][] visited;
    static Queue<Position> q; // 상근
    static Queue<Position> fireQ; // 불
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            visited = new boolean[N][M];
            q = new LinkedList<>();
            fireQ = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = ch[j];
                    if (arr[i][j] == '*') { // 불
                        fireQ.offer(new Position(i, j));
                    } else if (arr[i][j] == '@') { // 사람
                        q.offer(new Position(i, j, 0));
                    }
                }
            }
            result = 0;
            bfs();
            if (result == 0) {
                sb.append("IMPOSSIBLE").append('\n');
            } else {
                sb.append(result).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void bfs() {
        int size;
        while (!q.isEmpty()) {
            size = fireQ.size();
            // 불 먼저 번지게
            for (int f = 0; f < size; f++) {
                Position fire = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fire.x + dx[i];
                    int ny = fire.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (arr[nx][ny] == '.' || arr[nx][ny] == '@') {
                        arr[nx][ny] = '*';
                        fireQ.offer(new Position(nx, ny));
                    }
                }
            }

            size = q.size();
            for (int s = 0; s < size; s++) { // 상근 움직이기
                Position pos = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = pos.x + dx[i];
                    int ny = pos.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        result = pos.cnt + 1;
                        return;
                    }

                    if (arr[nx][ny] == '.') {
                        arr[nx][ny] = '@';
                        q.offer(new Position(nx, ny, pos.cnt + 1));
                    }
                }
            }
        }
    }
}
