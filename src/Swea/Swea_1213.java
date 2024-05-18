package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String search = br.readLine();
            String str = br.readLine();

            int result = 0;
            char first = search.charAt(0);
            for (int i = 0; i <= str.length() - search.length(); i++) {
                if (str.charAt(i) == first) {
                    boolean isSame = true;
                    for (int j = 0; j < search.length(); j++) {
                        if (str.charAt(i + j) != search.charAt(j)) {
                            isSame = false;
                            break;
                        }
                    }

                    if (isSame) {
                        result++;
                    }
                }
            }

            System.out.println("#" + n + " " + result);
        }
    }
}
