package Programmers.Lv_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(5, arr)));
    }

    public static int[] solution(int N, int[] stages) {
        int[] challengers = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challengers[stages[i]]++;
        }

        Map<Integer, Double> failMap = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challengers[i] == 0) {
                failMap.put(i, 0.0);
            } else {
                failMap.put(i, challengers[i] / total);
                total -= challengers[i];
            }
        }

        List<Integer> result = new ArrayList<>(failMap.keySet());
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double o1Score = failMap.get(o1);
                double o2Score = failMap.get(o2);

                if (o1Score == o2Score) {
                    return o1 - o2;
                }

                return Double.compare(o2Score, o1Score);
            }
        });

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
