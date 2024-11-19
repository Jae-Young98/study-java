package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[200001];
        int maxNum = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maxNum = Math.max(maxNum, a);
            if (b == 0) {
                if (arr[a] == 1) {
                    arr[a] = 0;
                } else {
                    result++;
                }
            } else {
                if (arr[a] == 0) {
                    arr[a] = 1;
                } else {
                    result++;
                }
            }
        }

        for (int i = 1; i <= maxNum; i++) {
            if (arr[i] != 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
