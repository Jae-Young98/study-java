package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<Book> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String str : map.keySet()) {
            list.add(new Book(str, map.get(str)));
        }
        Collections.sort(list);
        System.out.println(list.get(0).name);
    }

    public static class Book implements Comparable<Book> {
        String name;
        int count;

        Book(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Book o) {
            String s1 = this.name;
            String s2 = o.name;
            if (this.count == o.count) {
                return s1.compareTo(s2);
            }
            return o.count - this.count;
        }
    }
}
