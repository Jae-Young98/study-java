package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                resultList.add(str);
            }
        }

        Collections.sort(resultList);

        System.out.println(resultList.size());
        for (String str : resultList) {
            System.out.println(str);
        }

    }
}
