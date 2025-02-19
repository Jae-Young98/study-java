package Programmers.Lv_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 달리기_경주 {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRank = new HashMap<>();
        Map<Integer, String> rankPlayer = new HashMap<>();
        for (int i = 1; i <= players.length; i++) {
            playerRank.put(players[i - 1], i);
            rankPlayer.put(i, players[i - 1]);
        }

        for (int i = 0; i < callings.length; i++) {
            String call = callings[i];
            int current = playerRank.get(call);

            String forwardPlayer = rankPlayer.get(current - 1);
            int forwardRank = playerRank.get(forwardPlayer);

            playerRank.put(call, forwardRank);
            rankPlayer.put(forwardRank, call);

            playerRank.put(forwardPlayer, current);
            rankPlayer.put(current, forwardPlayer);
        }

        List<String> list = new ArrayList<>(playerRank.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return playerRank.get(o1) - playerRank.get(o2);
            }
        });

        return list.toArray(String[]::new);
    }
}
