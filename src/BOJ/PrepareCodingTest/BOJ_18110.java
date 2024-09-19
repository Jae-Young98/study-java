package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int cutting = (int) Math.round(n * 0.15);

        List<Integer> list = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            list.add(x);
        }

        Collections.sort(list);
        for (int i = 0; i < cutting; i++) {
            sum -= list.get(i);
            sum -= list.get(list.size() - 1 - i);
        }

        System.out.println(Math.round(sum / (n - (cutting * 2))));
    }
}
