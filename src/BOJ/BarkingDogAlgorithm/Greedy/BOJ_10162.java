package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = 300;
        int B = 60;
        int C = 10;

        int T = Integer.parseInt(br.readLine());
        if (T < 10) {
            System.out.println(-1);
            return;
        }
        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        while (T != 0) {
            aCount = T / A;
            T %= A;

            bCount = T / B;
            T %= B;

            cCount = T / C;
            T %= C;
        }
        System.out.println(aCount + " " + bCount + " " + cCount);
    }
}
