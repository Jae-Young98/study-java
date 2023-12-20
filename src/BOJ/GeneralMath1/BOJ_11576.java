package BOJ.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int ten = 0;
        int pow = m - 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ten += Integer.parseInt(st.nextToken()) * (Math.pow(A, pow));
            pow--;
        }

        Stack<Integer> stack = new Stack<>();
        while (ten != 0) {
            stack.push(ten % B);
            ten /= B;
        }

        while (!stack.isEmpty()) {
            System.out.printf(stack.pop() + " ");
        }
    }
}
