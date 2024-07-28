package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1063 {

    static int[][] arr;
    static Map<String, Point> map = new HashMap<>();
    static Point kingPosition;
    static Point stonePosition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int moveCount = Integer.parseInt(st.nextToken());

        // 왕 = 1, 돌 = 2
        arr = new int[8][8];

        int col = king.charAt(0) - 'A';
        int row = '8' - king.charAt(1);
        arr[row][col] = 1;
        kingPosition = new Point(row, col);

        col = stone.charAt(0) - 'A';
        row = '8' - stone.charAt(1);
        arr[row][col] = 2;
        stonePosition = new Point(row, col);

        /*
        R : 한 칸 오른쪽으로
        L : 한 칸 왼쪽으로
        B : 한 칸 아래로
        T : 한 칸 위로
        RT : 오른쪽 위 대각선으로
        LT : 왼쪽 위 대각선으로
        RB : 오른쪽 아래 대각선으로
        LB : 왼쪽 아래 대각선으로
        */
        map.put("R", new Point(0, 1));
        map.put("L", new Point(0, -1));
        map.put("B", new Point(1, 0));
        map.put("T", new Point(-1, 0));
        map.put("RT", new Point(-1, 1));
        map.put("LT", new Point(-1, -1));
        map.put("RB", new Point(1, 1));
        map.put("LB", new Point(1, -1));

        for (int i = 0; i < moveCount; i++) {
            String cmd = br.readLine();
            move(cmd);
        }

        int kingCol = 8 - kingPosition.x;
        char kingRow = (char) ((char) kingPosition.y + '0' + 17);

        int stoneCol = 8 - stonePosition.x;
        char stoneRow = (char) ((char) stonePosition.y + '0' + 17);

        sb.append(kingRow).append(kingCol).append('\n');
        sb.append(stoneRow).append(stoneCol).append('\n');
        System.out.print(sb);
    }

    public static void move(String cmd) {
        Point p = map.get(cmd);

        if (kingPosition.x + p.x == stonePosition.x && kingPosition.y + p.y == stonePosition.y) {
            if (kingPosition.x + p.x < 0 || kingPosition.x + p.x >= 8 || kingPosition.y + p.y < 0 || kingPosition.y + p.y >= 8
            || stonePosition.x + p.x < 0 || stonePosition.x + p.x >= 8 || stonePosition.y + p.y < 0 || stonePosition.y + p.y >= 8) {
                return;
            }

            arr[kingPosition.x][kingPosition.y] = 0;
            arr[stonePosition.x][stonePosition.y] = 0;

            kingPosition.x += p.x;
            kingPosition.y += p.y;
            stonePosition.x += p.x;
            stonePosition.y += p.y;
            arr[kingPosition.x][kingPosition.y] = 1;
            arr[stonePosition.x][stonePosition.y] = 2;
        } else {
            if (kingPosition.x + p.x < 0 || kingPosition.x + p.x >= 8 || kingPosition.y + p.y < 0 || kingPosition.y + p.y >= 8) {
                return;
            }

            arr[kingPosition.x][kingPosition.y] = 0;
            kingPosition.x += p.x;
            kingPosition.y += p.y;
            arr[kingPosition.x][kingPosition.y] = 1;
        }
    }
}
