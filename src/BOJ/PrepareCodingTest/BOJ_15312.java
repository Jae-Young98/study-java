package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15312 {

    static int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();

        int[] arr = new int[A.length() + B.length()];
        for (int i = 0; i < arr.length - 1; i += 2) {
            arr[i] = alpha[A.charAt(i / 2) - 65];
            arr[i + 1] = alpha[B.charAt(i / 2) - 65];
        }

        int size = arr.length;
        while (size > 2) {
            for (int i = 0; i < size - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            size--;
            arr[size] = 0;
        }

        sb.append(arr[0]).append(arr[1]);
        System.out.println(sb);
    }
}
