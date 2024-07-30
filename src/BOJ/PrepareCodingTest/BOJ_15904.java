package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String UCPC = "UCPC";
        char[] arr = br.readLine().toCharArray();

        int i = 0;
        for (char c : arr) {
            if (c == UCPC.charAt(i)) {
                i++;

                if (i == 4) {
                    break;
                }
            }
        }

        if (i == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
