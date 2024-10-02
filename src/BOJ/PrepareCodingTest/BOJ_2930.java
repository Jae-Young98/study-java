package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2930 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        int result = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < r; j++) {
                result += game(str.charAt(j), arr[i].charAt(j));
            }
        }
        sb.append(result).append('\n');
        result = 0;

        for (int i = 0; i < r; i++) {
            int a = 0;
            int b = 0;
            int c = 0;

            for (int j = 0; j < n; j++) {
                a += game('R', arr[j].charAt(i));
                b += game('P', arr[j].charAt(i));
                c += game('S', arr[j].charAt(i));
            }
            result += Math.max(a, Math.max(b, c));
        }
        sb.append(result).append('\n');
        System.out.print(sb);
    }

    public static int game(char a, char b) {
        if (a == b) {
            return 1;
        }

        if (a == 'R') {
            if (b == 'P') return 0;
            return 2;
        } else if (a == 'P') {
            if (b == 'R') return 2;
            return 0;
        } else {
            if (b == 'R') return 0;
            return 2;
        }
    }
}
