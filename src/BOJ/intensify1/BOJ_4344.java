package BOJ.intensify1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4344 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr;
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];

            double sum = 0;

            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(st.nextToken());
                arr[j] = score;
                sum += score;
            }

            double mean = sum / n;
            double count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] > mean) {
                    count++;
                }
            }
            String result = String.format("%.3f", (count/n)*100);
            bw.write(result + "%\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
