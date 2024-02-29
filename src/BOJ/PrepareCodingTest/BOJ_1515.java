package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int point = 0;
        int base = 0;
        while (true) {
             String temp = String.valueOf(base);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == str.charAt(point)) {
                    point++;
                }

                if (point == str.length()) {
                    System.out.println(base);
                    return;
                }
            }

            base++;
        }
    }
}
