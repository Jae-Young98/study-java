package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10984 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int total = 0;
            double sum = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                double b = Double.parseDouble(st.nextToken());

                total += a;
                sum += (a * b);
            }

            double gpa = sum / total;
            gpa = Math.round(gpa * 10) / 10.0;
            System.out.println(total + " " + gpa);
        }
    }
}
