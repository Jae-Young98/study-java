package Programmers.Lv_2;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }

    public static int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int[][] arr = new int[N][M];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = board[i];
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'R') {
                    queue.add(new Point(i, j));
                    arr[i][j] = 1;
                    break;
                }
            }
        }

        int answer = -1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (board[p.x].charAt(p.y) == 'G') {
                answer = arr[p.x][p.y] - 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                while (true) {
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx].charAt(ny) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                if (arr[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                }
            }
        }

        return answer;
    }
}
