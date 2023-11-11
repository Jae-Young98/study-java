package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int docGrade = Integer.parseInt(st.nextToken());
                int interviewGrade = Integer.parseInt(st.nextToken());
                arr[j][0] = docGrade;
                arr[j][1] = interviewGrade;
            }
            sb.append(getCount(arr)).append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    public static int getCount(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 1;
        int higherGrade = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][1] < higherGrade) {
                higherGrade = arr[i][1];
                count++;
            }
        }

        return count;
    }
}
