package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {

                if (j == 0 && str.charAt(j) == '0') {
                    continue;
                }

                if (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                    sb.append(str.charAt(j));
                } else {
                    if (sb.length() != 0) {
                        list.add(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }

            if (sb.length() != 0) {
                list.add(new BigInteger(sb.toString()));
            }
        }

        Collections.sort(list);
        for (BigInteger i : list) {
            System.out.println(i);
        }
    }
}
