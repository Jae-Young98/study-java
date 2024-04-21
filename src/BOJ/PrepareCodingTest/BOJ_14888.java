package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] arr;
    static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(int num, int idx) {
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) {
                    backtracking(num + arr[idx], idx + 1);
                } else if (i == 1) {
                    backtracking(num - arr[idx], idx + 1);
                } else if (i == 2) {
                    backtracking(num * arr[idx], idx + 1);
                } else {
                    backtracking(num / arr[idx], idx + 1);
                }

                operator[i]++;
            }
        }
    }
}
