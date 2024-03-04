package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        Character[] arr = new Character[S.length()];
        int one = 0;
        int zero = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = S.charAt(i);
            if (arr[i] == '0') {
                zero++;
            } else {
                one++;
            }
        }
        one /= 2;
        zero /= 2;

        for (int i = 0; i < arr.length && one != 0; i++) {
            if (arr[i] == '1') {
                arr[i] = 'x';
                one--;
            }
        }

        for (int i = arr.length - 1; i >= 0 && zero != 0; i--) {
            if (arr[i] == '0') {
                arr[i] = 'x';
                zero--;
            }
        }

        for (Character c : arr) {
            if (c != 'x') {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
