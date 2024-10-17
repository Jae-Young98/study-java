package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<Student>();
        Student[] students = new Student[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (students[num] != null) {
                students[num].like++;
            } else {
                Collections.sort(list);

                if (list.size() == n) {
                    Student out = list.remove(list.size() - 1);
                    students[out.number] = null;
                }

                students[num] = new Student(num, 1, i);
                list.add(students[num]);
            }
        }

        list.sort((o1, o2) -> o1.number - o2.number);
        for (Student s : list) {
            System.out.print(s.number + " ");
        }
    }

    static class Student implements Comparable<Student> {

        int number;
        int like;
        int time;

        Student(int number, int like, int time) {
            this.number = number;
            this.like = like;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.like == o.like) {
                return o.time - this.time;
            }

            return o.like - this.like;
        }
    }
}
