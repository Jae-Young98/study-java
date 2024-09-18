package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int result = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i))) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    static boolean isPalindrome(String str) {
        int s = 0;
        int e = str.length() - 1;
        while (s <= e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
