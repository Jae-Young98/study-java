package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Lecture(number, start, end));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                pq.offer(list.get(i).end);
            } else {
                int end = pq.peek();

                if (list.get(i).start < end) {
                    pq.add(list.get(i).end);
                } else {
                    pq.poll();
                    pq.add(list.get(i).end);
                }
            }
        }
        System.out.println(pq.size());
    }

    static class Lecture implements Comparable<Lecture> {

        int number;
        int start;
        int end;

        Lecture(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
