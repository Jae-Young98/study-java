package BOJ.BarkingDogAlgorithm.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine()," ");
        int[] findIdx = new int[m];
        for (int i = 0; i < m; i++) {
            findIdx[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int targetIdx = deque.indexOf(findIdx[i]);
            int halfIdx;

            if (deque.size() % 2 == 0) {
                halfIdx = deque.size() / 2 - 1;
            } else {
                halfIdx = deque.size() / 2;
            }

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    int temp = deque.pollFirst();
                    deque.offer(temp);
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.poll();
        }
        System.out.println(count);
    }
}
