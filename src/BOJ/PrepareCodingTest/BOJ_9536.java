package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Set<String> set = new HashSet<>();
            List<String> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                set.add(s);
                list.add(s);
            }

            while (true) {
                String str = br.readLine();

                if (str.equals("what does the fox say?")) {
                    break;
                }

                String[] arr = str.split(" ");
                set.remove(arr[2]);
            }

            for (String s : list) {
                if (set.contains(s)) {
                    sb.append(s).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}
