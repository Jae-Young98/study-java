package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] milks = {0, 1, 2};

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == milks[index]) {
                result++;
                index++;
            }

            if (index == 3) {
                index = 0;
            }
        }

        System.out.println(result);
    }
}
