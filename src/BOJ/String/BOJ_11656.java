package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();

        String input = br.readLine();
        while (!input.isBlank()) {
            strings.add(input);
            input = input.substring(1);
        }

        Collections.sort(strings);
        for (String str : strings) {
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }
}
