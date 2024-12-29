package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String start = "ABCDEF";
        char[] elem = {'A', 'F', 'C'};

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean flag = true;
            if (start.indexOf(str.charAt(0)) < 0) {
                sb.append("Good").append('\n');
                continue;
            }

            int now;
            if (str.charAt(0) == 'A') {
                now = 0;
            } else {
                now = 1;
            }

            for (int j = 0; j < elem.length; j++) {
                if (str.charAt(now) != elem[j]) {
                    sb.append("Good").append('\n');
                    flag = false;
                    break;
                } else {
                    for (int k = now; k < str.length(); k++) {
                        if (str.charAt(k) != elem[j]) {
                            now = k;
                            break;
                        } else {
                            now++;
                        }
                    }
                }
            }

            if (flag) {
                if (now == str.length()) {
                    sb.append("Infected!").append('\n');
                } else if (str.length() - now > 1) {
                    sb.append("Good").append('\n');
                } else {
                    if (start.indexOf(str.charAt(now)) < 0) {
                        sb.append("Good").append('\n');
                    } else {
                        sb.append("Infected!").append('\n');
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
