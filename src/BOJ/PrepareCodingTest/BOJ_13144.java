package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = 0;
        long result = 0;
        int[] check = new int[100001];
        while (l <= n) {
            while (r + 1 <= n && check[arr[r + 1]] == 0) {
                r++;
                check[arr[r]]++;
            }

            result += r - l + 1;
            check[arr[l++]]--;
        }

        System.out.println(result);
    }
}
