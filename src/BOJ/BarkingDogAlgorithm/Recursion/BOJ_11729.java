package BOJ.BarkingDogAlgorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, n) - 1)).append('\n');

        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + '\n');
            return;
        }

        // A -> C
        // n-1개를 A -> B
        hanoi(n - 1, start, to, mid);

        // 1개를 A -> C
        sb.append(start + " " + to + '\n');

        // n-1개를 B -> C
        hanoi(n - 1, mid, start, to);
    }
}
