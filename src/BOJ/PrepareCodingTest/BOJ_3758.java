package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int targetId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] list = new Team[n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (list[id - 1] == null) {
                    list[id - 1] = new Team(id, k);
                }

                list[id - 1].score[problemNum] = Math.max(list[id - 1].score[problemNum], score);
                list[id - 1].submitCount++;
                list[id - 1].lastSubmit = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    list[i].totalScore += list[i].score[j];
                }
            }

            Arrays.sort(list);
            for (int i = 0; i < n; i++) {
                if (list[i].id == targetId) {
                    System.out.println(i + 1);
                }
            }
        }
    }

    public static class Team implements Comparable<Team> {

        int id;
        int[] score;
        int lastSubmit = 0;
        int submitCount = 0;
        int totalScore = 0;

        Team(int id, int k) {
            this.id = id;
            this.score = new int[k + 1];
        }

        @Override
        public int compareTo(Team o) {
            if (this.totalScore == o.totalScore) {
                if (this.submitCount == o.submitCount) {
                    return this.lastSubmit - o.lastSubmit;
                }
                return this.submitCount - o.submitCount;
            }
            return o.totalScore - this.totalScore;
        }
    }
}
