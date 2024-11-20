package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_1972 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        loop:
        while (true) {
            String str = br.readLine();

            if (str.equals("*")) {
                break;
            }

            Set<String> set;
            for (int i = 1; i < str.length(); i++) {
                set = new HashSet<>();
                for (int j = 0; j < str.length() - i; j++) {
                    String subStr = String.valueOf(str.charAt(j)) + str.charAt(j + i);

                    if (!set.contains(subStr)) {
                        set.add(subStr);
                    } else {
                        sb.append(str).append(" is NOT surprising.").append('\n');
                        continue loop;
                    }
                }
            }
            sb.append(str).append(" is surprising.").append('\n');
        }
        System.out.print(sb);
    }
}
