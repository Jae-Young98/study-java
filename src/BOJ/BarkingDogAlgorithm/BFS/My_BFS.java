package BOJ.BarkingDogAlgorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class My_BFS {
    public static void main(String[] args) {

        // 그래프를 2차원 배열로 표현
        // 인덱스와 노드를 일치 시키기 위해 0은 저장하지 않음
        // 1번 인덱스 = 1번 노드, 배뎔의 값은 연결된 노드
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        // 방문했는지
        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
        // 예상 결과값 : 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7 ->
    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " -> ");
            // 큐에서 꺼낸 노드와 연결된 간선 체크
            for (int i = 0; i < graph[node].length; i++) {
                int temp = graph[node][i];
                // 방문하지 않았으면 방문처리 후에 큐에 삽입
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
        return sb.toString();
    }
}
