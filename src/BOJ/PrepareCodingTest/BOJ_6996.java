package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            char[] firstArr = first.toCharArray();
            char[] secondArr = second.toCharArray();

            Arrays.sort(firstArr);
            Arrays.sort(secondArr);

            if (Arrays.equals(firstArr, secondArr)) {
                System.out.println(first + " & " + second + " are anagrams.");
            } else {
                System.out.println(first + " & " + second + " are NOT anagrams.");
            }
        }
    }
}
