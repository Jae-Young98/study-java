package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_27964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
            if (str.length() >= 6) {
                String sub = str.substring(str.length() - 6);
                if (sub.equals("Cheese")) {
                    set.add(str);
                }
            }
        }

        if (set.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
