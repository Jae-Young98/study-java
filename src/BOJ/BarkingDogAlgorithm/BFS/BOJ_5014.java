package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int f, s, g, u, d; // 총 층수, 시작, 목표 층, 상승, 하강
    static int cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[f + 1];
        int result = bfs(s);
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result - 1);
        }
    }

    public static int bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        arr[s] = 1;

        while (!queue.isEmpty()) {
            int position = queue.poll(); // 현재
            if (position == g) {
                return arr[position];
            }
            // 다음 up 위치가 최대 층 보다 작고 방문하지 않아야함
            if (position + u <= f) {
                if (arr[position + u] == 0) {
                    arr[position + u] = arr[position] + 1;
                    queue.offer(position + u);
                }
            }
            if (position - d > 0) {
                if (arr[position - d] == 0) {
                    arr[position - d] = arr[position] + 1;
                    queue.offer(position - d);
                }
            }
        }
        return -1;
    }
}
