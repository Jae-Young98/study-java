package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int zero = 0;
        int one = 0;

        String str = br.readLine();
        if (str.charAt(0) == '0') {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
