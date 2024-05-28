package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<String> inCars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            inCars.add(br.readLine());
        }

        Queue<String> outCars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            outCars.add(br.readLine());
        }

        int result = 0;
        while (!outCars.isEmpty()) {
            String out = outCars.poll();

            if (!inCars.peek().equals(out)) {
                result++;
                inCars.remove(out);
            } else {
                inCars.poll();
            }
        }

        System.out.println(result);
    }
}
