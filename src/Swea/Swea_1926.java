package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);

            if (str.contains("3") || str.contains("6") || str.contains("9")) {
                for (int k = 0; k < str.length(); k++) {
                    if (str.charAt(k) == '3' || str.charAt(k) == '6' || str.charAt(k) == '9') {
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            } else {
                System.out.print(str + " ");
            }
        }
    }
}
