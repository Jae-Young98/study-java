package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String A = "AAAA";
        final String B = "BB";
        String source = br.readLine();

        source = source.replaceAll("XXXX", A);
        source = source.replaceAll("XX", B);

        if (source.contains("X")) {
            System.out.println(-1);
            return;
        }

        System.out.println(source);
    }
}
