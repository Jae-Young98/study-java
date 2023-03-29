package BOJ.intensify1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10812 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N+1];
        int[] tempBasket = new int[N+1];
        // 1번 부터 N번까지 번호가 적혀있는 바구니
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
            tempBasket[i] = i;
        }
        // 앞으로 M번 바구니의 순서 회전
        // 왼쪽으로부터 i번째 바구니부터 j번째 바구니 순서 회전,
        // 기준 바구니는 k번째 k번째 부터이다.
        // ex) 1 6 4 -> 4 5 6 1 2 3

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int ii = i;

            for (int n = 0; n < j - i + 1; n++) {
                if (k + n <= j) {
                    basket[n + i] = tempBasket[k + n];
                } else {
                    basket[n + i] = tempBasket[ii];
                    ii++;
                }
            }
            for (int n = 1; n <= N; n++) {
                tempBasket[n] = basket[n];
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(basket[i] + " ");
        }
        br.close();
        System.out.println(sb);
    }
}
