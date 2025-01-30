package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        int lVal = 0;
        int rVal = 0;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            int sum = arr[l] + arr[r];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                lVal = arr[l];
                rVal = arr[r];

                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.print(lVal + " " + rVal);
    }
}
