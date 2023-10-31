package BOJ.BarkingDogAlgorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String SK = "SK";
        final String CY = "CY";
        int N = Integer.parseInt(br.readLine());

        int result = N % 2;
        if (result == 1) {
            System.out.println(SK);
            return;
        }
        System.out.println(CY);
    }
}
