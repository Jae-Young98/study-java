package Programmers.Lv_1;

import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i : arr) {
            if (stack.peek() != i) {
                stack.push(i);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
