package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P;
        int L;
        int V;
        int i = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                System.out.print(sb);
                return;
            }

            int maxDay = (V / P) * L;
            int remain = V % P;
            maxDay += Math.min(remain, L);
            sb.append("Case ").append(i).append(": ").append(maxDay).append('\n');
            i++;
        }
    }
}
