package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int count = 0;
        int[] arrA = new int[26];
        int[] arrB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            arrA[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            arrB[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int compare = arrA[i] - arrB[i];

            if (compare != 0) {
                count += Math.abs(compare);
            }
        }

        System.out.println(count);
    }
}
