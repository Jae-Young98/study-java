package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_13706 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());
        BigInteger s = new BigInteger("1");
        BigInteger e = n;
        BigInteger mid;
        int result;

        while (true) {
            mid = s.add(e);
            mid = mid.divide(new BigInteger("2"));

            result = (mid.multiply(mid)).compareTo(n);

            if (result == 0) {
                break;
            } else if (result == 1) {
                // mid * mid > n
                e = mid.subtract(new BigInteger("1"));
            } else {
                s = mid.add(new BigInteger("1"));
            }
        }

        System.out.println(mid);
    }
}
