package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 2;

        if (n == 1) {
            System.out.println("1");
            return;
        }

        int result = 1;
        while (num <= n) {
            num += result * 6;
            result++;
        }
        System.out.println(result);
    }
}
