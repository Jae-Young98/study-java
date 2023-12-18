package BOJ.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int x = Integer.parseInt(String.valueOf(str.charAt(i)));
            int a = 0;
            int b = 0;
            if (x >= 4) {
                a = 1;
                x -= 4;
            }
            if (x >= 2) {
                b = 1;
                x -= 2;
            }
            if (i == 0) {
                if (a == 1) {
                    sb.append(a).append(b).append(x);
                } else if(b == 1) {
                    sb.append(b).append(x);
                } else {
                    sb.append(x);
                }
            } else {
                sb.append(a).append(b).append(x);
            }
        }

        System.out.print(sb);
    }
}
