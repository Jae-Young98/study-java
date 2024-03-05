package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19637 {

    static String[] nameArr;
    static int[] powerArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nameArr = new String[n];
        powerArr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nameArr[i] = st.nextToken();
            powerArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            String badge = getBadge(power);

            sb.append(badge).append('\n');
        }

        System.out.print(sb);
    }

    public static String getBadge(int power) {
        int left = 0;
        int right = powerArr.length - 1;
        while (left <= right) {
            int mid = (left  + right) / 2;

            if (powerArr[mid] < power) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nameArr[left];
    }
}
