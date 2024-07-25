package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long result = 0;

        while (n > 9) {
            long len = Long.toString(n).length();

            result += (n - Math.pow(10, len - 1) + 1) * len;
            n = (long) Math.pow(10, len - 1) - 1;
        }

        result += n;
        System.out.println(result % 1234567);
    }
}
