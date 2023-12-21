package BOJ.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] arr = new boolean[1001];
        arr[1] = true;

        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i + i; j <= 1000; j += i) {
                arr[j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (!arr[target]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
