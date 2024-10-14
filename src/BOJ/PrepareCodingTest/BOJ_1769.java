package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1769 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if (str.length() == 1) {
            int x = Integer.parseInt(str);

            if (x % 3 == 0) {
                System.out.println(0);
                System.out.println("YES");
                return;
            } else {
                System.out.println(0);
                System.out.println("NO");
                return;
            }
        }

        int count = 0;
        while (str.length() != 1) {
            long x = 0;
            for (int i = 0; i < str.length(); i++) {
                x += Long.parseLong(String.valueOf(str.charAt(i)));
            }
            count++;

            str = String.valueOf(x);
        }

        int x = Integer.parseInt(str);
        if (x % 3 == 0) {
            System.out.println(count);
            System.out.println("YES");
        } else {
            System.out.println(count);
            System.out.println("NO");
        }
    }
}
