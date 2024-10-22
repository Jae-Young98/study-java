package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1380 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n;
        int index = 0;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            index++;

            List<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                names.add(br.readLine());
            }

            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n * 2 - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                if (nums.contains(num)) {
                    nums.remove((Integer) num);
                } else {
                    nums.add(num);
                }
            }

            int result = nums.get(0);
            System.out.println(index + " " + names.get(result - 1));
        }
    }
}
