package BOJ.intensify1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (isGroup() == true) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isGroup() throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);

            if (prev != ch) {
                if (check[ch - 'a'] == false) {
                    check[ch - 'a'] = true;
                    prev = ch;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
