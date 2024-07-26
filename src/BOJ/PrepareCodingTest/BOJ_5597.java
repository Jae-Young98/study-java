package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[28];
        for (int i = 0; i < 28; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int x = 1;
        int i = 0;
        int count = 0;
        while (true) {
            if (arr[i] != x) {
                System.out.println(x);
                count++;
            } else {
                i++;
            }
            x++;

            if (count == 2) {
                return;
            }
        }
    }
}
