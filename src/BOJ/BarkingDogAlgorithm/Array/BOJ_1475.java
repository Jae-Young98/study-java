package BOJ.BarkingDogAlgorithm.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 9) {
                num = 6;
            }
            arr[num]++;
        }

        if (arr[6] % 2 == 1) {
            arr[6]++;
        }
        arr[6] /= 2;

        Arrays.sort(arr);

        System.out.println(arr[9]);
    }
}
