package BOJ.BarkingDogAlgorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        double result = 0;
        int idx = 0;
        Stack<Double> stack = new Stack<>();
        while (idx < str.length()) {
            char c = str.charAt(idx);
            if (c >= 'A' && c <= 'Z') {
                stack.push(arr[c - 'A']);
            } else if (c == '+') {
                double x = stack.pop();
                double y = stack.pop();
                result = (y + x);
                stack.push(result);
            } else if (c == '-') {
                double x = stack.pop();
                double y = stack.pop();
                result = (y - x);
                stack.push(result);
            } else if (c == '*') {
                double x = stack.pop();
                double y = stack.pop();
                result = (y * x);
                stack.push(result);
            } else if (c == '/') {
                double x = stack.pop();
                double y = stack.pop();
                result = (y / x);
                stack.push(result);
            }
            idx++;
        }
        System.out.printf("%.2f\n", result);
    }
}
