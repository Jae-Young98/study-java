package Programmers.Lv_2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = len - 1 - i;
        }

        return answer;
    }
}
