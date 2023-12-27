package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lecture(start, end));
        }

        Collections.sort(list);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int end = 0;
        for (Lecture lecture : list) {
            end = lecture.end;

            if (!queue.isEmpty() && queue.peek() <= lecture.start) {
                queue.poll();
            }
            queue.offer(end);
        }
        System.out.println(queue.size());
    }

    public static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.end) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
