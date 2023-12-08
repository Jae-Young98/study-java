package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr;
        while (true) {
            String str = br.readLine();

            if (str == null) {
                break;
            }

            arr = new int[4];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    arr[0]++;
                } else if (c >= 'A' && c <= 'Z') {
                    arr[1]++;
                } else if (c >= '0' && c <= '9') {
                    arr[2]++;
                } else {
                    arr[3]++;
                }
            }

            for (int i = 0; i < 4; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
