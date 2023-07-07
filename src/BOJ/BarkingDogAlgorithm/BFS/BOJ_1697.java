package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int n;
    static int k;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수빈
        k = Integer.parseInt(st.nextToken()); // 동생

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visit[n] = 1;

        while(!queue.isEmpty()) {
            int nowPos = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nextPos;

                if (i == 0) {
                    nextPos = nowPos - 1;
                } else if (i == 1) {
                    nextPos = nowPos + 1;
                } else {
                    nextPos = nowPos * 2;
                }

                if (nextPos == k) {
                    System.out.println(visit[nowPos]);
                    return;
                }

                if (nextPos >= 0 && nextPos < visit.length && visit[nextPos] == 0) {
                    queue.offer(nextPos);
                    visit[nextPos] = visit[nowPos] + 1;
                }
            }
        }
    }
}
