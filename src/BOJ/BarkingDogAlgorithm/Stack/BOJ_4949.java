package BOJ.BarkingDogAlgorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (char c: str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.empty() || stack.peek() != '(' ) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.empty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.empty()) {
                isValid = false;
            }

            if (isValid) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
