package BOJ.BarkingDogAlgorithm.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = n-1;
        int sum;
        int cnt = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        while(start < end) {
            sum = arr[start] + arr[end];
            if (sum == x) {
                cnt++;
                start++;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }
        br.close();
        System.out.println(cnt);
    }
}
