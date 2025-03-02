package Programmers.Lv_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class 베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genresPlays = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> genreNumPlay = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (genresPlays.containsKey(genre)) {
                genresPlays.put(genre, genresPlays.get(genre) + play);
                genreNumPlay.get(genre).put(i, play);
            } else {
                genresPlays.put(genre, play);

                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, play);
                genreNumPlay.put(genre, map);
            }
        }

        List<String> genreKeySet = new ArrayList<>(genresPlays.keySet());
        genreKeySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genresPlays.get(o2) - genresPlays.get(o1);
            }
        });

        List<Integer> answer = new ArrayList<>();
        for (String key : genreKeySet) {
            HashMap<Integer, Integer> map = genreNumPlay.get(key);
            List<Integer> list = new ArrayList<>(map.keySet());
            list.sort(new Comparator<>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (map.get(o1) == map.get(o2)) {
                        return o1 - o2;
                    }

                    return map.get(o2) - map.get(o1);
                }
            });

            answer.add(list.get(0));
            if (list.size() > 1) {
                answer.add(list.get(1));
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
