package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_5052 {

    static int n;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            Collections.sort(list);
            if (isStartWith()) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }
        System.out.print(sb);
    }

    public static boolean isStartWith() {
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i + 1).startsWith(list.get(i))) {
                return true;
            }
        }
        return false;
    }
}
