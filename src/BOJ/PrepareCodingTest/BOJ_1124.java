package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1124 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[100001];
        prime[0] = true;
        prime[1] = true;

        int[] count = new int[100001];
        for (int i = 2; i <= 100000; i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i + i; j <= 100000; j += i) {
                prime[j] = true;

                int temp = j;
                while (temp % i == 0) {
                    temp /= i;
                    count[j]++;
                }
            }
        }

        int result = 0;
        for (int i = a; i <= b; i++) {
            if (!prime[count[i]]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
