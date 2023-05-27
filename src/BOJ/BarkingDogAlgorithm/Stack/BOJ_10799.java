package BOJ.BarkingDogAlgorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                stack.pop();

                if (str.charAt(i-1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
