package BOJ.BarkingDogAlgorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int x;
    static int y;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = z((int)Math.pow(2, n), r, c);
        System.out.println(result);
    }

    public static int z(int n, int r, int c) {
        n /= 2;

        // 왼쪽 위
        if (r < x + n && c < y + n) {
            cnt += (n * n * 0);
        // 오른쪽 위
        } else if (r < x + n && c >= y + n) {
            cnt += (n * n * 1);
            y += n;
        // 왼쪽 아래
        } else if (c < y + n) {
            cnt += (n * n * 2);
            x += n;
        // 오른쪽 아래
        } else {
            cnt += (n * n * 3);
            x += n;
            y += n;
        }

        if (n == 1) {
            return cnt;
        }
        return z(n, r, c);
    }
}
