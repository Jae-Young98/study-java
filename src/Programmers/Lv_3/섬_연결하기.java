package Programmers.Lv_3;

import java.util.Arrays;

public class 섬_연결하기 {

    static int[] parent;
    static int answer = 0;

    public static void main(String[] args) {
        // kruskal
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        parent = new int[n];

        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 노드 집합 초기화
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] arr : costs) {
            if (find(arr[0]) != find(arr[1])) {
                union(arr[0], arr[1]);
                answer += arr[2];

            }
        }
        return answer;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}
