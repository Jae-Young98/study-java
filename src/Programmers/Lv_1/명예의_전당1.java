package Programmers.Lv_1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의_전당1 {

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);

            if (pq.size() > k) {
                pq.poll();
            }

            answer[i] = pq.peek();
        }
        return answer;
    }
}
