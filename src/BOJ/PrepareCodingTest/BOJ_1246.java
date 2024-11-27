package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1246 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int maxSum = 0;
        int maxPi = 0;
        Collections.sort(list);
        for (int i = 0; i < m; i++) {
            int nowPi = list.get(i);
            int nowSum = 0;

            if (m - i < n) {
                nowSum = nowPi * (m - i);
            } else {
                nowSum = nowPi * n;
            }

            if (nowSum > maxSum) {
                maxSum = nowSum;
                maxPi = nowPi;
            }
        }

        System.out.println(maxPi + " " + maxSum);
    }
}
