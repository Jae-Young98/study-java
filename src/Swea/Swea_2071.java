package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2071 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            double avg = sum / 10.0;
            avg = Math.round(avg);
            sb.append("#").append(t).append(' ').append((int) avg).append('\n');
        }
        System.out.print(sb);
    }
}
