package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int aLength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aLength++;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int bLength = 0;
            for (int j = i; j < i + aLength; j++) {
                if (str.charAt(j % str.length()) == 'b') {
                    bLength++;
                }
            }
            result = Math.min(result, bLength);
        }
        System.out.println(result);
    }
}
