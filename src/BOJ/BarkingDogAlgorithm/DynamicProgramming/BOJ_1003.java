package BOJ.BarkingDogAlgorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1003 {

    static int t;
    static int[][] d = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < d.length; i++) {
            Arrays.fill(d[i], -1);
        }
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(d[n][0] + " " + d[n][1]).append('\n');
        }
        System.out.print(sb);
    }

    static int[] fibonacci(int n) {
        if(d[n][0] == -1 || d[n][1] == -1) {
            d[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            d[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return d[n];
    }
}
