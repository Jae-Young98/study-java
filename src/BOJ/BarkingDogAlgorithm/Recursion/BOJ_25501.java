package BOJ.BarkingDogAlgorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501 {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            result = 0 ;
            sb.append(isPalindrome(str)).append(" ").append(result).append('\n');
        }
        System.out.print(sb);
    }

    public static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    public static int recursion(String str, int left, int right) {
        result++;

        if (left >= right) {
            return 1;
        } else if (str.charAt(left) != str.charAt(right)) {
            return 0;
        } else {
            return recursion(str, left + 1, right - 1);
        }
    }
}
