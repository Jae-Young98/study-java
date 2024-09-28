package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Set<String> set;
        int k = 1;
        while (true) {
            set = new HashSet<>();

            for (String str : list) {
                String split = str.substring(str.length() - k);

                if (set.contains(split)) {
                    k++;
                    break;
                } else {
                    set.add(split);
                }
            }

            if (set.size() == list.size()) {
                break;
            }
        }

        System.out.println(k);
    }
}
