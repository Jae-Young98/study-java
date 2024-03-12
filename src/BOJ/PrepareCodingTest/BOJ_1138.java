package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int front = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                // 앞에 아무도 없음에도 자리에 값이 있다면 현재 수 보다 작음
                if (front == 0 && arr[j] == 0) {
                    arr[j] = i + 1;
                    break;
                } else if (arr[j] == 0) {
                    front--;
                }
            }
        }

        for (int i : arr) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
