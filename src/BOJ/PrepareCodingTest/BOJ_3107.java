package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(":");
        int len = arr.length;
        for (String str : arr) {
            if (str.isEmpty()) {
                len--;
            }
        }

        int index = 0;
        int count = 0;
        while (index < arr.length) {
            String temp = arr[index];
            if (temp.isEmpty() && len < 8) {
                sb.append("0000").append(":");
                count++;
                len++;
            } else if (temp.isEmpty()) {
                index++;
                continue;
            } else {
                for (int i = 0; i < 4 - temp.length(); i++) {
                    sb.append("0");
                }
                sb.append(temp);
                index++;
                count++;
                if (count < 8) {
                    sb.append(":");
                }
            }
        }

        while (count < 8) {
            sb.append("0000");
            count++;
            if (count < 8) {
                sb.append(":");
            }
        }
        System.out.println(sb);
    }
}
