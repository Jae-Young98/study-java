package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;
            int dir = 0;
            int nowX = 0;
            int nowY = 0;

            String cmd = br.readLine();
            for (int i = 0; i < cmd.length(); i++) {
                char c = cmd.charAt(i);

                if (c == 'F') {
                    nowX += dx[dir];
                    nowY += dy[dir];
                } else if (c == 'B') {
                    nowX -= dx[dir];
                    nowY -= dy[dir];
                } else if (c == 'L') {
                    if (dir == 0) {
                        dir = 3;
                    } else {
                        dir--;
                    }
                } else {
                    if (dir == 3) {
                        dir = 0;
                    } else {
                        dir++;
                    }
                }

                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }
            int result = (Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY));
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
