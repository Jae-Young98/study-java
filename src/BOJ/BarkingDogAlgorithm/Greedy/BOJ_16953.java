package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int result = 1;
        while (A != B) {
            if (B < A) {
                System.out.println(-1);
                return;
            }

            if (B % 10 == 1) {
                B /= 10;
                result++;
                continue;
            }

            if (B % 2 == 0) {
                B /= 2;
                result++;
                continue;
            }
            result = -1;
            break;
        }

        System.out.println(result);
    }
}
