package Programmers.Lv_1.Kakao;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장_많이_받은_선물 {

    public static int solution(String[] friends, String[] gifts) {
        StringTokenizer st;
        int length = friends.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(friends[i], i);
        }

        int[][] arr = new int[length][length];
        int[] score = new int[length];
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            String from = st.nextToken();
            String to = st.nextToken();

            int f = map.get(from);
            int t = map.get(to);
            arr[f][t]++;
            score[f]++;
            score[t]--;
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            int count = 0;
            int from = map.get(friends[i]);
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                int to = map.get(friends[j]);

                // 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 선물을 하나 받음
                if (arr[from][to] > arr[to][from]) {
                    count++;

                // 두 사람이 주고받은 기록이 없거나 같으면, 지수가 더 큰 사람이 더 작은 사람에게 선물을 하나 받음 (지수 = 준 선물 - 받은 선물)
                } else if ((arr[from][to] == 0 && arr[to][from] == 0)
                        || arr[from][to] == arr[to][from]) {
                    if (score[from] > score[to]) {
                        count++;
                    }
                }
                // 두 사람의 지수도 같으면 주고받지 않음
            }
            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));

        friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan",
                "david alessandro", "alessandro david"};
        System.out.println(solution(friends, gifts));

        friends = new String[]{"a", "b", "c"};
        gifts = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println(solution(friends, gifts));
    }
}
