package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();

            for (int j = 0; j < 8; j++) {
                char c = str.charAt(j);

                if ((i + j) % 2 == 0 && c == 'F') {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
