package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr;
        String first = br.readLine();

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            arr = first.toCharArray();
            String str = br.readLine();

            if (calculate(arr, str)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean calculate(char[] arr, String str) {
        int remainStr = str.length();
        int remainArr = arr.length;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == c) {
                    remainStr--;
                    remainArr--;
                    arr[j] = '.';
                    break;
                }
            }
        }

        return remainArr <= 1 && remainStr <= 1;
    }
}