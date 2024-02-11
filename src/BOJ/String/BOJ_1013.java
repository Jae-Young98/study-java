package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1013 {

    private static final String REGEX = "(100+1+|01)+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.matches(REGEX)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
