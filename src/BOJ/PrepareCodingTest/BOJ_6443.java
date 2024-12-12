package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6443 {

    static char[] string;
    static int[] visited;
    static Stack<Character> stack;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            string = br.readLine().toCharArray();

            visited = new int[26];
            for (char c : string) {
                visited[c - 'a']++;
            }

            stack = new Stack<>();
            comb(0);
        }

        System.out.println(sb);
    }

    static void comb(int s) {
        if (s == string.length) {
            for (char c : stack) {
                sb.append(c);
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                stack.push((char)(i + 'a'));
                comb(s + 1);
                visited[i]++;
                stack.pop();
            }
        }
    }
}
