package Programmers.Lv_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 신고_결과_받기 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> idIndexMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> reportedMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
            reportedMap.put(i, new HashSet<>());
        }

        HashMap<Integer, Integer> reportCount = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);

            int from = idIndexMap.get(st.nextToken());
            int to = idIndexMap.get(st.nextToken());
            Set<Integer> reportSet = reportedMap.get(from);
            if (!reportSet.contains(to)) {
                reportSet.add(to);
                reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
            }
            reportedMap.put(from, reportSet);
        }

        List<String> list = new ArrayList<>(idIndexMap.keySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return idIndexMap.get(o1).compareTo(idIndexMap.get(o2));
            }
        });

        List<Integer> answer = new ArrayList<>();
        for (String str : list) {
            int id = idIndexMap.get(str);
            Set<Integer> set = reportedMap.get(id);

            int count = 0;
            for (int j : set) {
                if (reportCount.get(j) >= k) {
                    count++;
                }
            }
            answer.add(count);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
