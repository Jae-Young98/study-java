package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_21425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (a > n || b > n) {
                System.out.println(1);
            }

            int count = 0;
            while (true) {
                if (a > b) {
                    b += a;
                } else {
                    a += b;
                }
                count++;

                if (a > n || b > n) {
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}
