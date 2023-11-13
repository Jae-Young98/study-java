package BOJ.BarkingDogAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        boolean[] primeArr;

        int max = 0;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            list.add(N);
            max = Math.max(max, N);
        }
        max *= 2;

        primeArr = new boolean[max + 1];
        primeArr[0] = true;
        primeArr[1] = true;
        for (int i = 2; i < Math.sqrt(max); i++) {
            if (!primeArr[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primeArr[j] = true;
                }
            }
        }

        for (int target : list) {
            int count = 0;
            for (int j = target + 1; j <= 2 * target; j++) {
                if (!primeArr[j]) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
