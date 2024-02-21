package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Medal> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Medal(index, gold, silver, bronze));
        }
        Collections.sort(list);

        list.get(0).rank = 1;
        
        int num = 0;
        for (int i = 1; i < list.size(); i++) {
            Medal prev = list.get(i - 1);
            Medal now = list.get(i);
            
            if (now.index == k) {
                num = i;
            }
            
            if (now.gold == prev.gold && now.silver == prev.silver && now.bronze == prev.bronze) {
                now.rank = prev.rank;
            } else {
                now.rank = i + 1;
            }
        }

        System.out.println(list.get(num).rank);
    }

    static class Medal implements Comparable<Medal> {
        int index;
        int gold;
        int silver;
        int bronze;
        int rank;

        Medal(int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            rank = 0;
        }

        @Override
        public int compareTo(Medal o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }
}
