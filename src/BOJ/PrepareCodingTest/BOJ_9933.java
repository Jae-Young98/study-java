package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            set.add(str);

            sb = new StringBuilder();
            sb.append(str).reverse();

            if (set.contains(sb.toString())) {
                System.out.println(str.length() + " " + str.charAt(str.length() / 2));
                return;
            }
        }
    }
}
