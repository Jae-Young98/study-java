package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"", "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        String str = br.readLine();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            String target = String.valueOf(str.charAt(i));
            for (int j = 3; j < arr.length; j++) {
                if (arr[j].contains(target)) {
                    result += j;
                }
            }
        }
        System.out.println(result);
    }
}
