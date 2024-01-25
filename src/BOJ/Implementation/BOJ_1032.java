package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();

        for (int i = 0; i < n - 1; i++) {
            char[] file = br.readLine().toCharArray();

            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != file[j]) {
                    pattern[j] = '?';
                }
            }
        }
        System.out.println(pattern);
    }
}
