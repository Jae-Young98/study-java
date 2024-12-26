package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        long len = 1;
        long count = 9;

        while (k > len * count) {
            k -= (len * count);
            len++;
            count *= 10;
        }

        k -= 1;
        long num = (long) Math.pow(10, (len - 1)) + (k / len);
        if (num > n) {
            System.out.println(-1);
        } else {
            String number = String.valueOf(num);
            System.out.println(number.charAt((int) (k % len)));
        }
    }
}
