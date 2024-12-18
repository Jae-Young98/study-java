package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String l = st.nextToken();
        String r = st.nextToken();

        if (l.length() != r.length()) {
            System.out.println(0);
            return;
        }

        int result = 0;
        for (int i = 0; i < l.length(); i++) {
            char lC = l.charAt(i);
            char rC = r.charAt(i);

            if (lC != rC) {
                break;
            }

            if (lC == '8') {
                result++;
            }
        }

        System.out.println(result);
    }
}
