package BOJ.BarkingDogAlgorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 빌딩 높이 받기
            int h = Integer.parseInt(br.readLine());
            // 스택이 비어있지 않으면 들어올 빌딩 높이와 비교
            // 들어올 빌딩 높이보다 작으면 pop
            while(!stack.isEmpty()) {
                if (stack.peek() <= h) {
                    stack.pop();
                } else {
                    break;
                }
            }
            // 결과에 스택의 사이즈 더하기 (벤치마킹 가능한 개수)
            result += stack.size();
            // 스택에 빌딩 푸시
            stack.push(h);
        }
        System.out.println(result);
    }
}
