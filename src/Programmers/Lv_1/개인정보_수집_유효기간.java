package Programmers.Lv_1;

import java.util.*;

public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        String[] todayArr = today.split("\\.");
        int todayYear = Integer.parseInt(todayArr[0]);
        int todayMonth = Integer.parseInt(todayArr[1]);
        int todayDay = Integer.parseInt(todayArr[2]);


        int todayToDay = (todayYear * 12 * 28) + (todayMonth * 28) + todayDay;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String[] date = st.nextToken().split("\\.");

            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            int term = termsMap.get(st.nextToken()) * 28;

            int privacyToDay = (year * 12 * 28) + (month * 28) + day + term;

            if (privacyToDay <= todayToDay) {
                pq.offer(i + 1);
            }
        }

        int[] answer = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            answer[i] = pq.poll();
            i++;
        }
        return answer;
    }
}
