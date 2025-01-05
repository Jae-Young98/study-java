package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1091 {

    static int n;
    static int[] p;
    static int[] s;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        p = new int[n];
        s = new int[n];
        temp = new int[n];
        st = new StringTokenizer(br.readLine());
        // i 번 카드는 p[i]로 가야한다.
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        temp = p;
        while (true) {
            if (check()) {
                System.out.println(result);
                return;
            }

            shuffle();
            result++;

            if (Arrays.equals(p, temp)) {
                System.out.println(-1);
                return;
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            if (temp[i] != i % 3) {
                return false;
            }
        }
        return true;
    }

    static void shuffle() {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[s[i]] = temp[i];
        }

        temp = arr;
    }
}
