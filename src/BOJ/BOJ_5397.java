package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (str.charAt(j) == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (str.charAt(j) == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(str.charAt(j));
                }
            }
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
