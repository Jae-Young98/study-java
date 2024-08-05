package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new Student(country, number, score));
            map.put(country, 0);
        }

        Collections.sort(list);
        int count = 0;
        int i = 0;
        while (count < 3) {
            Student student = list.get(i);

            if (map.get(student.country) == 2) {
                i++;
                continue;
            }

            System.out.println(student.country + " " + student.number);
            map.put(student.country, map.get(student.country) + 1);
            count++;
            i++;
        }
    }

    public static class Student implements Comparable<Student> {
        int country;
        int number;
        int score;

        Student(int country, int number, int score) {
            this.country = country;
            this.number = number;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }
}
