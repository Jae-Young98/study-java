package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            List<School> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                list.add(new School(st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);

            sb.append(list.get(0).name).append('\n');
        }

        System.out.print(sb);
    }

    static class School implements Comparable<School> {

        String name;
        int quantity;

        School(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(School o) {
            return o.quantity - this.quantity;
        }
    }
}
