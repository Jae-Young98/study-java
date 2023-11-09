package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int FIVE_WON = 5;
        final int TWO_WON = 2;
        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 3) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        count += N / FIVE_WON;
        N %= FIVE_WON;
        while (N != 0) {
            if (N % TWO_WON != 0 && count > 0) {
                count--;
                N += FIVE_WON;
            }
            if (N % TWO_WON == 0) {
                count += N / TWO_WON;
                break;
            }
        }
        System.out.println(count);
    }
}
