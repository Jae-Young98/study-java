package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4821 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int page = Integer.parseInt(br.readLine());

            if (page == 0) {
                break;
            }

            int[] arr = new int[page + 1];
            st = new StringTokenizer(br.readLine(), ",");

            int count = 0;
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if (!str.contains("-")) {
                    int x = Integer.parseInt(str);
                    if (x > page) {
                        continue;
                    }

                    if (arr[x] == 0) {
                        arr[x] = 1;
                        count++;
                    }
                    continue;
                }
                String[] nums = str.split("-");
                int l = Integer.parseInt(nums[0]);
                int r = Integer.parseInt(nums[1]);

                if (l > r) {
                    continue;
                }

                for (int i = l; i <= r; i++) {
                    if (i > page) {
                        break;
                    }

                    if (arr[i] == 0) {
                        arr[i] = 1;
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}
