package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7490 {

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");
            System.out.println(sb);
        }
    }

    static void dfs(int index, int num, int sum, int op, String ex) {
        if (index == n) {
            sum += (num * op);

            if (sum == 0) {
                sb.append(ex).append('\n');
            }

            return;
        }

        // 공백
        dfs(index + 1, num * 10 + (index + 1), sum, op, ex + " " + (index + 1));
        // 덧셈
        dfs(index + 1, index + 1, sum + (num * op), 1, ex + "+" + (index + 1));
        // 뺄셈
        dfs(index + 1, index + 1, sum + (num * op), -1, ex + "-" + (index + 1));
    }
}
