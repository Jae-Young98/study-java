package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_20551 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());

            if (!set.contains(x)) {
                sb.append(-1).append('\n');
                continue;
            }

            int l = 0;
            int r = n - 1;
            int result = -1;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (arr[mid] < x) {
                    l = mid + 1;
                } else {
                    result = mid;
                    r = mid - 1;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
