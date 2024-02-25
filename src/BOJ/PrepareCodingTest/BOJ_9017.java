package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] rankArr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int team = Integer.parseInt(st.nextToken());
                map.put(team, map.getOrDefault(team, 0) + 1); // 팀 인원수
                rankArr[i] = team;
                max = Math.max(max, team);
            }

            int[] fifthScore = new int[max + 1];
            Map<Integer, Integer> teamScore = new HashMap<>();
            Map<Integer, Integer> temp = new HashMap<>();

            int score = 1;
            for (int rank : rankArr) {
                if (map.get(rank) == 6) {
                    temp.put(rank, temp.getOrDefault(rank, 0) + 1);

                    if (temp.get(rank) <= 4) {
                        teamScore.put(rank, teamScore.getOrDefault(rank, 0) + score);
                    }

                    if (temp.get(rank) == 5) {
                        fifthScore[rank] = score;
                    }

                    score++;
                }
            }

            int winner = Integer.MAX_VALUE;
            int fifth = Integer.MAX_VALUE;
            int result = 0;
            for (Integer key : teamScore.keySet()) {
                int current = teamScore.get(key);
                if (current < winner) {
                    winner = current;
                    fifth = fifthScore[key];
                    result = key;
                } else if (current == winner) {
                    if (fifth > fifthScore[key]) {
                        result = key;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
