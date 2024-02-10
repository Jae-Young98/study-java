package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new Person(name, day, month, year));
        }
        Collections.sort(list);

        System.out.println(list.get(0).name);
        System.out.println(list.get(list.size() - 1).name);
    }

    static class Person implements Comparable<Person> {

        String name;
        int day;
        int month;
        int year;

        Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Person o) {
            if (this.year == o.year) {
                if (this.month == o.month) {
                    return o.day - this.day;
                }
                return o.month - this.month;
            }
            return o.year - this.year;
        }
    }
}
