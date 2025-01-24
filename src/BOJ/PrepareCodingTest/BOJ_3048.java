package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Ant> list = new ArrayList<>();

        String str = br.readLine();
        for (int i = a - 1; i >= 0 ; i--) {
            list.add(new Ant('A', str.charAt(i)));
        }

        str = br.readLine();
        for (int i = 0; i < b; i++) {
            list.add(new Ant('B', str.charAt(i)));
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                Ant now = list.get(j);
                Ant next = list.get(j + 1);

                if (now.group == 'A' && next.group == 'B') {
                    list.set(j, next);
                    list.set(j + 1, now);
                    j++;
                }
            }
        }

        for (Ant ant : list) {
            sb.append(ant.name);
        }

        System.out.println(sb);
    }

    static class Ant {
        char group;
        char name;

        Ant(char group, char name) {
            this.group = group;
            this.name = name;
        }
    }
}
