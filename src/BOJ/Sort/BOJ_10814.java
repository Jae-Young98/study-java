package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<People> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new People(age, name));
        }

        Collections.sort(list);
        for (People p : list) {
            sb.append(p.age).append(" ").append(p.name).append('\n');
        }
        System.out.print(sb);
    }

    public static class People implements Comparable<People> {
        int age;
        String name;

        People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(People o) {
            if (this.age == o.age) {
                return 0;
            }
            return this.age - o.age;
        }
    }
}
