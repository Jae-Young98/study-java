package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_14729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Float> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Float.parseFloat(br.readLine()));
        }

        for (int i = 0 ; i < 7; i++) {
            System.out.printf("%.3f\n", pq.poll());
        }
    }
}
