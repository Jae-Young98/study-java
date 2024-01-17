package BOJ.BarkingDogAlgorithm.BinarrySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] - mid > 0) {
                    sum += arr[i] - mid;
                }
            }

            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
