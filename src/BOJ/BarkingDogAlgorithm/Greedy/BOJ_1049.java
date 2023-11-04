package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pack = Integer.MAX_VALUE;
        int each = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            each = Math.min(each, Integer.parseInt(st.nextToken()));
        }

        int buyPack = 0;
        int buyPackEach = 0;
        int buyEach = 0;
        if (N % 6 == 0) {
            buyPack = pack * (N / 6);
        }
        if (N % 6 != 0) {
            buyPack = pack * ((N / 6) + 1);
        }
        buyPackEach = (pack * (N / 6)) + (each * (N % 6));
        buyEach = each * N;

        int result = Math.min(buyPack, Math.min(buyPackEach, buyEach));

        System.out.println(result);
    }
}
