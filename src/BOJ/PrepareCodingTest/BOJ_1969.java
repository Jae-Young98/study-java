package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            int[] count = new int[4]; // A C G T
            for (int j = 0; j < n; j++) {
                char c = arr[j][i];

                if (c == 'A') {
                    count[0]++;
                } else if (c == 'C') {
                    count[1]++;
                } else if (c == 'G') {
                    count[2]++;
                } else {
                    count[3]++;
                }
            }

            int idx = 0;
            int max = 0;
            for (int k = 0; k < 4; k++) {
                if (count[k] > max || (count[k] == max && k < idx)) {
                    max = count[k];
                    idx = k;
                }
            }

            if (idx == 0) {
                sb.append('A');
            } else if (idx == 1) {
                sb.append('C');
            } else if (idx == 2) {
                sb.append('G');
            } else {
                sb.append('T');
            }

            result += n - max;
        }
        sb.append('\n').append(result);
        System.out.println(sb);
    }
}
