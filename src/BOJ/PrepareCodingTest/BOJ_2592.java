package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2592 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1001];
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            arr[x]++;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 1001; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println(sum / 10);
        System.out.println(maxIndex);
    }
}
