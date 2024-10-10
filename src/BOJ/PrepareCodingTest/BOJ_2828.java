package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int l = 0;
        int r = m - 1;
        int distance = 0;

        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine()) - 1;

            if (apple > r) {
                distance += apple - r;
                r = apple;
                l = apple - (m - 1);
            } else if (apple < l) {
                distance += l - apple;
                l = apple;
                r = apple + (m - 1);
            }
        }

        System.out.println(distance);
    }
}
