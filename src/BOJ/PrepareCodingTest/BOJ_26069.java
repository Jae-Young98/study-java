package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_26069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<String>();
        set.add("ChongChong");

        String memberA;
        String memberB;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            memberA = st.nextToken();
            memberB = st.nextToken();

            if (set.contains(memberA) || set.contains(memberB)) {
                set.add(memberA);
                set.add(memberB);
            }
        }

        System.out.println(set.size());
    }
}
