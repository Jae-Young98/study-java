package Programmers.Lv_2;

import java.util.HashMap;
import java.util.Stack;

public class 괄호_회전하기 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack;

        int answer = 0;
        int len = s.length();
        s += s;

        for (int i = 0; i < len; i++) {
            stack = new Stack<>();

            for (int j = i; j < i + len; j++) {
                char c = s.charAt(j);

                if (map.containsKey(c)) {
                    if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
