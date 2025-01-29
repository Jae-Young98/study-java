package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];
        int index = 1;
        for (int i = 1; i <= 1000 ; i++) {
            for (int j = 1; j <= i ; j++) {
                if (index > 1000) {
                    break;
                }
                arr[index] = i;
                index++;
            }
        }

        int result = 0;
        for (int i = a; i <= b; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
