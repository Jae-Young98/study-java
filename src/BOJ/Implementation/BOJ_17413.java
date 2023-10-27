package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {

    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static String str;
    static int i = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '<') {
                stackToStringBuilder();
                checkBracket();
                continue;
            }
            stack.push(c);
            i++;
            if (i < str.length() && str.charAt(i) == ' ') {
                stackToStringBuilder();
                sb.append(' ');
                i++;
            }
        }
        stackToStringBuilder();

        System.out.println(sb);
    }

    public static void checkBracket() {
        while (str.charAt(i) != '>') {
            sb.append(str.charAt(i));
            i++;
        }
        if (str.charAt(i) == '>') {
            sb.append(str.charAt(i));
            i++;
        }
    }

    public static void stackToStringBuilder() {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
