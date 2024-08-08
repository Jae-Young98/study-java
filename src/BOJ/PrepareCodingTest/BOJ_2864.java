package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        String aMin = a;
        String bMin = b;
        aMin = aMin.replaceAll("6", "5");
        bMin = bMin.replaceAll("6", "5");

        int min = Integer.parseInt(aMin) + Integer.parseInt(bMin);

        String aMax = a;
        String bMax = b;
        aMax = aMax.replaceAll("5", "6");
        bMax = bMax.replaceAll("5", "6");

        int max = Integer.parseInt(aMax) + Integer.parseInt(bMax);

        System.out.println(min + " " + max);
    }
}
