package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int line = 1;

        while (N > line) {
            N -= line;
            line++;
        }

        if (line % 2 == 0) {
            System.out.println(N + "/" + (line - N + 1));
        } else {
            System.out.println((line - N + 1) + "/" + N);
        }
    }
}
