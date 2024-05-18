package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1289 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();

            int result = 0;
            char c = '0';
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != c) {
                    c = str.charAt(i);
                    result++;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
