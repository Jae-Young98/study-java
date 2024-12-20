package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int result = 2;
            String str = br.readLine();
            StringBuilder builder = new StringBuilder(str);

            if (str.equals(builder.reverse().toString())) {
                result = 0;
            }

            int l = 0;
            int r = str.length() - 1;
            while (l < r) {
                char lc = str.charAt(l);
                char rc = str.charAt(r);

                if (lc != rc) {
                    StringBuilder delLeft = new StringBuilder(str).deleteCharAt(l);
                    StringBuilder delRight = new StringBuilder(str).deleteCharAt(r);

                    if (delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())) {
                        result = 1;
                    }
                    break;
                }
                l++;
                r--;
            }

            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
