package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Subject> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            if (x == 1) {
                int a = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (t == 1) {
                    result += a;
                } else {
                    stack.push(new Subject(a, t));
                }
            } else if (!stack.isEmpty()) {
                Subject subject = stack.pop();
                subject.t--;

                if (subject.t == 0) {
                    result += subject.a;
                } else {
                    stack.push(subject);
                }
            }
        }

        System.out.println(result);
    }

    static class Subject {
        int a;
        int t;

        Subject(int a, int t) {
            this.a = a;
            this.t = t - 1;
        }
    }
}
