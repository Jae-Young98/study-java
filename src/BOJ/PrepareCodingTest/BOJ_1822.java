package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            set.remove(Integer.parseInt(st.nextToken()));
        }

        System.out.println(set.size());
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
