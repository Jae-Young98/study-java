package BOJ.BarkingDogAlgorithm.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll(); // 버리기
            int x = queue.poll(); // 옮기기
            queue.offer(x); // 옮기기
        }
        System.out.println(queue.poll());
    }
}
