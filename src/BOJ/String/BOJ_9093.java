package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();

            String[] arr = str.split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].length() == 1) {
                    sb.append(arr[j]).append(" ");
                } else {
                    StringBuilder builder = new StringBuilder(arr[j]).reverse();
                    sb.append(builder).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}