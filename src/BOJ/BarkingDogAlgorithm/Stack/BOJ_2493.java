package BOJ.BarkingDogAlgorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>(); // 탑 위치

        for (int i = 1; i <= n; i++) {

            int tower = Integer.parseInt(st.nextToken());
            while(true) {
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top > tower) {
                        sb.append(index.peek() + " ");
                        stack.push(tower);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }
                } else {
                    sb.append("0 ");
                    stack.push(tower);
                    index.push(i);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
