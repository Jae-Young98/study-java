package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {

    static int R, C, T;
    static int cleanerTop;
    static int cleanerBottom;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Dust> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        boolean isFirstCleaner = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == -1 && !isFirstCleaner) {
                    cleanerTop = i;
                    isFirstCleaner = true;
                } else if (arr[i][j] == -1 && isFirstCleaner){
                    cleanerBottom = i;
                }
            }
        }
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != -1) {
                        queue.offer(new Dust(i, j, arr[i][j]));
                    }
                }
            }
            bfs();
            runCleaner();
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != -1) {
                    result += arr[i][j];
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Dust now = queue.poll();

            if (now.amount < 5) {
                continue;
            }

            int spread = now.amount / 5;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == -1) {
                    continue;
                }

                arr[nx][ny] += spread;
                arr[now.x][now.y] -= spread;
            }
        }
    }

    public static void runCleaner() {
        // 위쪽 공기청정기
        // 위에서 아래
        for (int i = cleanerTop - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        // 오른쪽에서 왼쪽
        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        // 아래에서 위로
        for (int i = 0; i < cleanerTop; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }
        // 왼쪽에서 오른쪽
        for (int i = C - 1; i > 1; i--) {
            arr[cleanerTop][i] = arr[cleanerTop][i - 1];
        }
        arr[cleanerTop][1] = 0;

        // 아래쪽 공기청정기
        // 아래에서 위
        for (int i = cleanerBottom + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        // 오른쪽에서 왼쪽
        for (int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
        // 위에서 아래
        for (int i = R - 1; i > cleanerBottom; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        // 왼쪽에서 오른쪽
        for (int i = C - 1; i > 1; i--) {
            arr[cleanerBottom][i] = arr[cleanerBottom][i - 1];
        }
        arr[cleanerBottom][1] = 0;
    }

    static class Dust {
        int x;
        int y;
        int amount;

        Dust(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }
}
