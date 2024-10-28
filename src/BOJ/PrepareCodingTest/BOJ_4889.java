package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while (true) {
            String str = br.readLine();

            if (str.contains("-")) {
                break;
            }

            int len = str.length();
            int count = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);

                if (c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        count++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(index).append(". ").append(count + stack.size() / 2).append('\n');
            index++;
        }

        System.out.print(sb);
    }
}
