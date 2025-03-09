package Programmers.Lv_3;

import java.util.ArrayList;
import java.util.List;

public class 양과_늑대 {

    static List<List<Integer>> tree = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        System.out.println(solution(info, edges));
    }

    public static int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited, info);

        return answer;
    }

    public static void dfs(int now, int sheep, int wolf, boolean[] visited, int[] info) {
        if (info[now] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        boolean[] newVisited = visited.clone();
        newVisited[now] = true;

        answer = Math.max(answer, sheep);

        for (int i = 0; i < tree.size(); i++) {
            if (newVisited[i]) {
                for (int j : tree.get(i)) {
                    if (!newVisited[j]) {
                        dfs(j, sheep, wolf, newVisited, info);
                    }
                }
            }
        }
    }
}
