package BOJ.BarkingDogAlgorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점 번호

        boolean[] visited = new boolean[n + 1];

        int[][] adjArray = new int[n+1][n+1];

        // 두 정점 사이에 여러 개의 간선이 있을 수 있음
        // 입력으로 주어지는 간선은 양방향
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjArray[v1][v2] = 1;
            adjArray[v2][v1] = 1;
        }
        System.out.println("BFS - 인접행렬");
        bfsArray(v, adjArray, visited);
    }

    public static void bfsArray(int v, int[][] adjArray, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int n = adjArray.length - 1;

        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= n; i++) {
                if (adjArray[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
