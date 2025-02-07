package Programmers.Lv_2;

import java.util.HashSet;

public class 방문_길이 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        String dirs1 = "URULDD";
        System.out.println(solution(dirs1));
    }

    public static int solution(String dirs) {
        HashSet<String> set = new HashSet<>();

        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int d = getDir(dirs.charAt(i));

            nx = x + dx[d];
            ny = y + dy[d];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                nx = x;
                ny = y;
                continue;
            }

            set.add(x + " " + y + " " + nx + " " + ny);
            set.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }

        return set.size() / 2;
    }

    static int getDir(char c) {
        if (c == 'R') {
            return 0;
        }

        if (c == 'D') {
            return 1;
        }

        if (c == 'L') {
            return 2;
        }

        return 3;
    }
}
