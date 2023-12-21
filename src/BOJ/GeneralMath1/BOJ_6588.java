package BOJ.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1000001];
        arr[1] = 0;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= 1000000; j += i) {
                arr[j] = 0;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.print(sb);
                return;
            }

            boolean isGoldbach = false;
            for (int i = 2; i <= n / 2; i++) {
                if (arr[i] + arr[n - i] == n) {
                    sb.append(n).append(" = ").append(arr[i]).append(" + ").append(arr[n - i]).append('\n');
                    isGoldbach = true;
                    break;
                }
            }
            if (!isGoldbach) {
                sb.append("Goldbach's conjecture is wrong.").append('\n');
            }
        }
    }
}
