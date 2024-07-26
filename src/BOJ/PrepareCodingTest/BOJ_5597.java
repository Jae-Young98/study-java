package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = true;
        }

        int count = 0;
        for (int i = 1; i <= 30; i++) {
            if (!arr[i]) {
                System.out.println(i);
                count++;
            }

            if (count == 2) {
                return;
            }
        }
    }
}
