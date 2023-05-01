package BOJ.BarkingDogAlgorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (stack.empty()) {
                    stack.push(n);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(n);
            }
        }

        while(!stack.empty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
