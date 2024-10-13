package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_2056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] maxDayArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(' ');
            String str = br.readLine();
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String day = str.substring(6, 8);

            int intMonth = Integer.parseInt(month);
            if (intMonth < 1 || intMonth > 12) {
                sb.append(-1).append('\n');
                continue;
            }

            int intDay = Integer.parseInt(day);
            if (intDay > maxDayArr[intMonth] || intDay < 1) {
                sb.append(-1).append('\n');
                continue;
            }

            sb.append(year).append("/").append(month).append("/").append(day).append('\n');
        }

        System.out.print(sb);
    }
}
