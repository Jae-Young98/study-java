package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int sLen = s.length();
        int tLen = t.length();

        int lcm = (sLen * tLen) / gcd(sLen, tLen);

        StringBuilder sLcmStr = new StringBuilder(s);
        for (int i = 0; i < lcm / sLen - 1; i++) {
            sLcmStr.append(s);
        }

        StringBuilder tLcmStr = new StringBuilder(t);
        for (int i = 0; i < lcm / tLen - 1; i++) {
            tLcmStr.append(t);
        }

        if (sLcmStr.toString().equals(tLcmStr.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
