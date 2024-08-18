package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_11536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        String[] sorted = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i] = str;
            sorted[i] = str;
        }

        boolean flag = false;
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(sorted[i])) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("INCREASING");
            return;
        }

        flag = false;
        Arrays.sort(sorted, Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(sorted[i])) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("DECREASING");
            return;
        }

        System.out.println("NEITHER");
    }
}
