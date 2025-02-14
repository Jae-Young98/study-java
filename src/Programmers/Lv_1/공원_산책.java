package Programmers.Lv_1;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 공원_산책 {

    // E, S, W, N
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int x, y;
    static int n, m;

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes) {
        x = 0;
        y = 0;
        n = park.length;
        m = park[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        StringTokenizer st;
        for (String route : routes) {
            st = new StringTokenizer(route);
            String cmd = st.nextToken();
            int dir = 0;
            if (cmd.equals("S")) {
                dir = 1;
            } else if (cmd.equals("W")) {
                dir = 2;
            } else if (cmd.equals("N")) {
                dir = 3;
            }

            int count = Integer.parseInt(st.nextToken());

            int tempX = x;
            int tempY = y;
            int move = 0;
            for (int j = 0; j < count; j++) {
                int nx = tempX + dx[dir];
                int ny = tempY + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || park[nx].charAt(ny) == 'X') {
                    break;
                }

                move++;
                tempX = nx;
                tempY = ny;
            }

            if (move == count) {
                x = tempX;
                y = tempY;
            }
        }

        return new int[]{x, y};
    }
}
