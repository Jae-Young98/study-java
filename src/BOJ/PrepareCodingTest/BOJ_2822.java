package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Score> list = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(new Score(i, Integer.parseInt(br.readLine())));
        }

        Collections.sort(list);
        int sum = 0;
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sum += list.get(i).score;
            idx.add(list.get(i).idx);
        }

        System.out.println(sum);
        Collections.sort(idx);
        for (int i = 0; i < 5; i++) {
            System.out.print(idx.get(i) + " ");
        }
    }

    static class Score implements Comparable<Score> {
        int idx;
        int score;

        Score(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Score o) {
            return o.score - this.score;
        }
    }
}
