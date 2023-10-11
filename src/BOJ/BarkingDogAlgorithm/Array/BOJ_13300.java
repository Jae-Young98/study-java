package BOJ.BarkingDogAlgorithm.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[7][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[grade][gender]++;
        }

        int result = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j <= 1; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                if (arr[i][j] % k != 0) {
                    result++;
                }
                result += arr[i][j] / k;
            }
        }
        System.out.println(result);
    }
}
