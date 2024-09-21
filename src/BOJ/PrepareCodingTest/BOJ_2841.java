package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!stack[line].isEmpty()) {
                if (stack[line].peek() < fret) {
                    stack[line].push(fret);
                } else if (stack[line].peek() > fret) {
                    stack[line].pop();
                } else {
                    break;
                }

                result++;
            }

            if (stack[line].isEmpty()) {
                stack[line].push(fret);
                result++;
            }
        }

        System.out.println(result);
    }
}
