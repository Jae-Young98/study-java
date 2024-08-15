package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (set.contains(str)) {
                set.remove(str);
            }
            set.add(str);
        }

        int count = 0;
        for (String str : set) {
            System.out.println(str);
            count++;

            if (count == k) {
                break;
            }
        }
    }
}
