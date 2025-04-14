package Programmers.Lv_2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int n = maps.length;
        int m = maps[0].length;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) {
                    continue;
                }

                queue.offer(new Position(nx, ny, now.cnt + 1));
                maps[nx][ny] = 0;
            }
        }

        return answer;
    }

    public static class Position {
        int x;
        int y;
        int cnt;

        Position(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
