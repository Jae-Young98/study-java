package BOJ.BarkingDogAlgorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][RED] = Integer.parseInt(st.nextToken());
            arr[i][GREEN] = Integer.parseInt(st.nextToken());
            arr[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            arr[i][RED] += Math.min(arr[i-1][GREEN], arr[i-1][BLUE]);
            arr[i][GREEN] += Math.min(arr[i-1][RED], arr[i-1][BLUE]);
            arr[i][BLUE] += Math.min(arr[i-1][RED], arr[i-1][GREEN]);
        }

        System.out.println(Math.min(arr[N-1][RED], Math.min(arr[N-1][GREEN], arr[N-1][BLUE])));
    }
}
