package BOJ.BarkingDogAlgorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b));
    }

    public static long pow(long a, long b) {
        // 지수가 1
        if (b == 1) {
            return a % c;
        }

        // 지수의 절반
        long tmp = pow(a, b/ 2);

        /*
         * 지수가 홀수면
         * A^(b / 2) * A^(b / 2) * a
         */
        if (b % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }
        return tmp * tmp % c;
    }
}
