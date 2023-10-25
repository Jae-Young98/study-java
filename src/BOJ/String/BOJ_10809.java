package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            if (alphabet[c] == -1) {
                alphabet[c] = i;
            }
        }

        for (int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}
