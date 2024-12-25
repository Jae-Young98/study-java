package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        if (list.get(0) > crane[0]) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while (!list.isEmpty()) {
            int cranePos = 0;
            int boxPos = 0;

            while (cranePos < n) {
                if (boxPos == list.size()) {
                    break;
                } else if (crane[cranePos] >= list.get(boxPos)) {
                    list.remove(boxPos);
                    cranePos++;
                } else {
                    boxPos++;
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
