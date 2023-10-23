package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Target[] array = new Target[N];
        for (int i = 0; i < N; i++) {
            array[i] = new Target(br.readLine());
        }

        List<Target> list = Arrays.asList(array);
        list.stream()
                .distinct()
                .sorted()
                .forEach(result -> System.out.println(result.str));
    }

    static class Target implements Comparable<Target> {
        String str;

        public Target(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(Target t1) {
            String s1 = this.str;
            String s2 = t1.str;
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            } else {
                return s1.compareTo(s2);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Target) {
                return str.equals(((Target) o).str);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return str.hashCode();
        }
    }
}
