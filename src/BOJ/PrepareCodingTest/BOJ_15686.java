package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {

    static int n;
    static int m;
    static int[][] arr;
    static List<Point> persons;
    static List<Point> chickens;
    static int result = Integer.MAX_VALUE;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        persons = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    persons.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int s, int count) {
        if (count == m) {
            int x = 0;

            for (int i = 0; i < persons.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                // 집과 치킨집 중 오픈한 치킨집의 모든 거리 비교, 최소 거리
                for (int j = 0; j < chickens.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(persons.get(i).x - chickens.get(j).x) + Math.abs(persons.get(i).y - chickens.get(j).y);

                        tmp = Math.min(tmp, distance);
                    }
                }

                x += tmp;
            }

            result = Math.min(result, x);
            return;
        }

        // backtracking
        for (int i = s; i < chickens.size(); i++) {
            open[i] = true;
            dfs(i + 1, count + 1);
            open[i] = false;
        }
    }
}
