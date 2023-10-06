package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = arr.length - 1;
            int target = Integer.parseInt(st.nextToken());
            int result = binarySearch(arr, target, left, right);
            sb.append(result).append(" ");
        }
        System.out.println(sb);

    }

    public static int binarySearch(int[] arr, int x, int left, int right) {
        if (left > right) {
            return 0;
        }

        int mid = (left + right) / 2;

        if (x == arr[mid]) {
            return 1;
        }

        if (x > arr[mid]) {
            return binarySearch(arr, x, mid + 1, right);
        }
        return binarySearch(arr, x, left, mid - 1);
    }
}
