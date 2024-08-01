package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int o1Num = 0;
                int o2Num = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int n1 = o1.charAt(i) - '0';
                    int n2 = o2.charAt(i) - '0';
                    if (n1 > 0 && n1 < 10) {
                        o1Num += n1;
                    }
                    if (n2 > 0 && n2 < 10) {
                        o2Num += n2;
                    }
                }
                if (o1Num == o2Num) {
                    return o1.compareToIgnoreCase(o2);
                }
                return o1Num - o2Num;
            }
        });

        for (String str : list) {
            System.out.println(str);
        }
    }
}
