package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        while (true) {
            int x = Integer.parseInt(br.readLine());

            if (x == -1) {
                break;
            }

            if (x == 0) {
                queue.remove();
            } else if (queue.size() < n) {
                queue.add(x);
            }
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            for (int x : queue) {
                sb.append(x).append(" ");
            }
        }
        System.out.println(sb);
    }
}
