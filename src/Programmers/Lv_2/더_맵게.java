package Programmers.Lv_2;

import java.util.PriorityQueue;

public class 더_맵게 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        int answer = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                break;
            }

            int first = pq.poll();
            int second = pq.poll() * 2;
            pq.offer(first + second);
            answer++;
        }

        if (pq.isEmpty() || pq.peek() < K) {
            return -1;
        }

        return answer;
    }
}
