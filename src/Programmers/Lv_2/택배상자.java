package Programmers.Lv_2;

import java.util.Stack;

public class 택배상자 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }

    public static int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                if (stack.peek() == order[idx]) {
                    stack.pop();
                    idx++;
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
