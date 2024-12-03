package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boolean flag = false;

            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if (flag) {
                    sb.append(str).append(' ');
                } else if (!set.contains(Character.toUpperCase(str.charAt(0)))) {
                    set.add(Character.toUpperCase(str.charAt(0)));
                    str = "[" + str.charAt(0) + "]" + str.substring(1);
                    if (!list.isEmpty()) {
                        for (String s : list) {
                            sb.append(s).append(' ');
                        }
                        list.clear();
                    }
                    sb.append(str).append(' ');
                    flag = true;
                } else {
                    list.add(str);
                }
            }
            if (!flag) {
                for (int j = 0; j < list.size(); j++) {
                    String str = list.get(j);
                    if (!flag) {
                        for (int k = 0; k < str.length(); k++) {
                            if (!set.contains(Character.toUpperCase(str.charAt(k)))) {
                                set.add(Character.toUpperCase(str.charAt(k)));
                                str = str.substring(0, k) + "[" + str.charAt(k) + "]"
                                        + str.substring(k + 1);
                                flag = true;
                                break;
                            }
                        }
                    }
                    sb.append(str).append(' ');
                }
            }
            list.clear();
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
