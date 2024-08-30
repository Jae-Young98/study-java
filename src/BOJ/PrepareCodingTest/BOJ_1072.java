package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((long) y * 100 / x);

        int result = -1;
        int l = 0;
        int r = 1000000000;
        while (l <= r) {
            int mid = (l + r) / 2;
            int rate = (int) ((long) (y + mid) * 100 / (x + mid));
            if (rate != z) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
}
