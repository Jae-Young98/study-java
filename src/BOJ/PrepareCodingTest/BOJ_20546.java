package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cash = Integer.parseInt(br.readLine());

        int[] stocks = new int[14];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }

        int junhyun = getJunhyun(cash, stocks);
        int sungmin = getSungmin(cash, stocks);

        if (junhyun > sungmin) {
            System.out.println("BNP");
        } else if (junhyun < sungmin) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int getJunhyun(int cash, int[] stocks) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < 14; i++) {
            if (stocks[i] <= cash) {
                count += cash / stocks[i];
                cash = cash % stocks[i];
            }
        }

        result = cash + (stocks[13] * count);
        return result;
    }

    private static int getSungmin(int cash, int[] stocks) {
        int result = 0;
        int count = 0;

        for (int i = 3; i < 14; i++) {
            if (stocks[i - 1] < stocks[i - 2] && stocks[i - 2] < stocks[i - 3] && cash >= stocks[i]) {
                count = cash / stocks[i];
                cash -= stocks[i] * count;
            } else if (stocks[i - 1] > stocks[i - 2] && stocks[i - 2] > stocks[i - 3]) {
                cash += stocks[i] * count;
                count = 0;
            }
        }

        result = cash + (stocks[13] * count);
        return result;
    }
}
