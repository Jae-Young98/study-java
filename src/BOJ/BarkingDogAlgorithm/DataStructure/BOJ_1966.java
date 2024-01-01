package BOJ.BarkingDogAlgorithm.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> index = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
                index.offer(j);
            }

            int count = 1;
            while (!queue.isEmpty()) {
                int max = Collections.max(queue);
                int current = queue.poll();
                int currentIdx = index.poll();

                if (current == max) {
                    if (currentIdx == m) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                } else {
                    queue.offer(current);
                    index.offer(currentIdx);
                }
            }

        }
    }
}
