package BOJ.intensify1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N-i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i*2-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = N-1; i >= 1; i--) {
            for (int j = 0; j < N-i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i*2-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
