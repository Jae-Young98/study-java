package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {

    static int N, K;
    static char[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N];
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                canEat(i);
            }
        }
        System.out.println(result);
    }

    public static void canEat(int p) {
        int start = p - K;
        int end = p + K;
        if (p - K < 0) {
            start = 0;
        }
        if (p + K >= N) {
            end = N - 1;
        }

        for (int i = start; i <= end; i++) {
            if (arr[i] == 'H') {
                result++;
                arr[i] = 'X';
                return;
            }
        }
    }
}
