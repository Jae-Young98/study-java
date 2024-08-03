package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[988];

        for (int i = 123; i <= 987; i++) {
            String str = String.valueOf(i);

            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                continue;
            }

            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) {
                continue;
            }

            check[i] = true;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 123; j <= 987; j++) {
                if (check[j]) {
                    int strikeN = 0;
                    int bN = 0;

                    for (int input = 0; input < 3; input++) {
                        char splitNum = Integer.toString(num).charAt(input);

                        for (int k = 0; k < 3; k++) {
                            char splitJ = Integer.toString(j).charAt(k);

                            if (splitNum == splitJ && input == k) {
                                strikeN++;
                            } else if (splitNum == splitJ && input != k) {
                                bN++;
                            }
                        }
                    }

                    if (strikeN == strike && bN == ball) {
                        check[j] = true;
                    } else {
                        check[j] = false;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 123; i<= 987; i++) {
            if (check[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
