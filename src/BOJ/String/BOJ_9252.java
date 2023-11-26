package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp;
        String str1 = br.readLine();
        String str2 = br.readLine();
        dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 1; i <= str2.length(); i++) {
            char c = str2.charAt(i - 1);
            for (int j = 1; j <= str1.length(); j++) {
                if (c == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[str2.length()][str1.length()]);

        Stack<Character> stack = new Stack<>();
        int firstLength = str1.length();
        int secondLength = str2.length();

        while (firstLength != 0 && secondLength != 0) {
            // 같은 문자
            if (str2.charAt(secondLength - 1) == str1.charAt(firstLength - 1)) {
                stack.push(str2.charAt(secondLength - 1));
                firstLength--;
                secondLength--;
                // 다른 문자
            } else if (dp[secondLength][firstLength] == dp[secondLength - 1][firstLength]) {
                secondLength--;
            } else {
                firstLength--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
