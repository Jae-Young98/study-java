package BOJ.BarkingDogAlgorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

    static int n, s;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        if (s == 0) {
            System.out.println(result - 1);
            return;
        }
        System.out.println(result);
    }

    public static void dfs(int sum, int depth) {
        if (depth == n) {
            if (sum == s) {
                result++;
            }
            return;
        }

        dfs(sum + arr[depth], depth + 1);
        dfs(sum, depth + 1);
    }
}
