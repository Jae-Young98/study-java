package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685 {

    static boolean[][] arr = new boolean[101][101];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            list.add(d);
            makeCurve(g);
            draw(x, y);
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] && arr[i][j + 1] && arr[i + 1][j] && arr[i + 1][j + 1]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void draw(int x, int y) {
        int nx = x;
        int ny = y;
        arr[x][y] = true;

        for (int d : list) {
            nx += dx[d];
            ny += dy[d];
            arr[nx][ny] = true;
        }
    }

    public static void makeCurve(int g) {
        for (int i = 0; i < g; i++) {
            int size = list.size();

            for (int j = 1; j <= size; j++) {
                list.add((list.get(size - j) + 1) % 4);
            }
        }
    }
}
