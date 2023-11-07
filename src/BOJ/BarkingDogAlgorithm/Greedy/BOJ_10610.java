package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_10610 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] arr = new Integer[str.length()];

        boolean isThirty = false;
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
            if (arr[i] == 0) {
                isThirty = true;
            }
        }

        if (!isThirty) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (Integer integer : arr) {
            sum += integer;
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
        }

        if (sum % 3 == 0) {
            Arrays.sort(arr, Collections.reverseOrder());
            makeResult(arr);
        }

        System.out.println(sb);
    }

    public static void makeResult(Integer[] arr) {
        for (int i : arr) {
            sb.append(i);
        }
    }
}
