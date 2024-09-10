package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] patternStr = br.readLine().split("\\*");
        Pattern pattern = Pattern.compile(patternStr[0] + ".*" + patternStr[1]);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Matcher matcher = pattern.matcher(str);

            if (matcher.matches()) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
