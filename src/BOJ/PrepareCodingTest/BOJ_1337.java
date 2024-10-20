package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1337 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int max = 1;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                set.add(now + j);
            }

            int count = 1;
            for (int j = i + 1; j < i + 5; j++) {
                if (j < n) {
                    if (set.contains(arr[j])) {
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(5 - max);
    }
}
