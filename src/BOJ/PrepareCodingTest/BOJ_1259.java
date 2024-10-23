package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (true) {
            str = br.readLine();

            if (str.equals("0")) {
                break;
            }

            String reverse = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reverse += str.charAt(i);
            }

            if (str.equals(reverse)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
