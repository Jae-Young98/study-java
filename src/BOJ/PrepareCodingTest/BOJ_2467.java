package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftRes = 0;
        int rightRes = 0;
        int left = 0;
        int right = n - 1;
        int result = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < result) {
                result = Math.abs(sum);
                leftRes = arr[left];
                rightRes = arr[right];
            }

            if (sum <= 0) {
                left++;
            } else {
                right--;
            }
        }

        sb.append(leftRes).append(' ').append(rightRes);
        System.out.println(sb);
    }
}
