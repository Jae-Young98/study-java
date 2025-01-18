package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1;
        StringBuilder sb2;
        StringBuilder sb3;

        String str = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 2; i < str.length(); i++) {
            for (int j = 1; j < i; j++) {
                sb1 = new StringBuilder(str.substring(0, j));
                sb2 = new StringBuilder(str.substring(j, i));
                sb3 = new StringBuilder(str.substring(i));
                String a = sb1.reverse().toString();
                String b = sb2.reverse().toString();
                String c = sb3.reverse().toString();
                list.add(a + b + c);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
