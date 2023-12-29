package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String explosive = br.readLine();
        int explosiveLen = explosive.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= explosiveLen) {
                boolean isSame = true;
                for (int j = 0; j < explosiveLen; j++) {
                    if (stack.get(stack.size() - explosiveLen + j) != explosive.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j = 0; j < explosiveLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        for (char c : stack) {
            sb.append(c);
        }
        if (sb.length() == 0) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(sb);
    }
}