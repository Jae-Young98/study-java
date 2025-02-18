package Programmers.Lv_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드_뭉치 {

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardsQueue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardsQueue2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalQueue = new LinkedList<>(Arrays.asList(goal));

        while (!goalQueue.isEmpty()) {
            if (!cardsQueue1.isEmpty() && cardsQueue1.peek().equals(goalQueue.peek())) {
                cardsQueue1.poll();
                goalQueue.poll();
            } else if (!cardsQueue2.isEmpty() && cardsQueue2.peek().equals(goalQueue.peek())) {
                cardsQueue2.poll();
                goalQueue.poll();
            } else {
                break;
            }
        }

        if (goalQueue.isEmpty()) {
            return "Yes";
        }
        return "No";
    }
}
