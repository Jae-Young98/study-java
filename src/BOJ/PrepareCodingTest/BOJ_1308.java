package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1308 {

    static int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowY = Integer.parseInt(st.nextToken());
        int nowM = Integer.parseInt(st.nextToken());
        int nowD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endY = Integer.parseInt(st.nextToken());
        int endM = Integer.parseInt(st.nextToken());
        int endD = Integer.parseInt(st.nextToken());

        if (nowY + 1000 < endY || nowY + 1000 == endY && (nowM < endM || nowM == endM && nowD <= endD)) {
            System.out.println("gg");
            return;
        }

        int result = convertDate(endY, endM, endD) - convertDate(nowY, nowM, nowD);
        System.out.printf("D-%d\n", result);
    }

    public static int convertDate(int y, int m, int d) {
        int result = 0;

        for (int i = 1; i < y; i++) {
            result += (365 + isLeapYear(i));
        }

        for (int i = 1; i < m; i++) {
            result += arr[i];
            if (i == 2) {
                result += isLeapYear(y);
            }
        }
        return result + d;
    }

    public static int isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return 1;
        }

        return 0;
    }
}
