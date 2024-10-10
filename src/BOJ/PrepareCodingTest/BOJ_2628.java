package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        rows.add(0);
        cols.add(0);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                rows.add(Integer.parseInt(st.nextToken()));
            } else {
                cols.add(Integer.parseInt(st.nextToken()));
            }
        }

        rows.add(N);
        cols.add(M);
        Collections.sort(rows);
        Collections.sort(cols);

        int row = 0;
        int col = 0;
        for (int i = 0; i < rows.size() - 1; i++) {
            int x = rows.get(i + 1) - rows.get(i);
            if (x > row) {
                row = x;
            }
        }

        for (int i = 0; i < cols.size() - 1; i++) {
            int x = cols.get(i + 1) - cols.get(i);
            if (x > col) {
                col = x;
            }
        }
        System.out.println(row * col);
    }
}
