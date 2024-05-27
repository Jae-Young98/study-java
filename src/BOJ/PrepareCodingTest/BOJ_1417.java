package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.peek() >= dasom) {
            int current = pq.poll();
            current--;
            dasom++;
            result++;
            pq.add(current);
        }

        System.out.println(result);
    }
}
