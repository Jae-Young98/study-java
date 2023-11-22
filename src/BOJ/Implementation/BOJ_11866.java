package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append('<');
        while (!list.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                if (i == K) {
                    if (list.size() == 1) {
                        sb.append(list.get(0));
                        list.remove(0);
                    } else {
                        sb.append(list.get(0)).append(", ");
                        list.remove(0);
                    }
                } else {
                    list.add(list.get(0));
                    list.remove(0);
                }
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}
