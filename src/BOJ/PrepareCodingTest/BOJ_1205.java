package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        if (list.size() == p && newScore <= list.get(list.size() - 1)) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (newScore >= list.get(i)) {
                rank = i + 1;
                break;
            } else {
                rank++;
            }
        }

        if (rank <= p) {
            System.out.println(rank);
        } else {
            System.out.println(-1);
        }
    }
}
