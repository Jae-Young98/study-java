package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = Integer.MAX_VALUE;
        int end = -1;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[l] = h;
            start = Math.min(start, l);
            end = Math.max(end, l);
        }

        Stack<Integer> stack = new Stack<>();
        // 왼쪽
        int tmp = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < tmp) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = tmp;
                }
                tmp = arr[i];
            }
        }
        stack.clear();

        // 오른쪽
        tmp = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < tmp) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = tmp;
                }
                tmp = arr[i];
            }
        }

        int result = 0 ;
        for (int i = start; i <= end; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
