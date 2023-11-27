package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int aSize = a.length();
        int bSize = b.length();

        a = a.replace(b, "");
        System.out.println((aSize - a.length()) / bSize);
    }
}
