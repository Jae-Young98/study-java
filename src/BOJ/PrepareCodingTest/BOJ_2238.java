package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        People[] peoples = new People[u + 1];
        for (int i = 0; i <= u; i++) {
            peoples[i] = new People(i);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            peoples[price].names.add(name);
        }
//         1. 가장 적은 수의 사람이 제시한 가격
//         2. 여럿 이면 가장 낮은 가격에 판매
//         3. 가장 먼저 제시한 사람이 구매
        Arrays.sort(peoples);
        for (int i = 0; i <= u; i++) {
            if (!peoples[i].names.isEmpty()) {
                System.out.println(peoples[i].names.poll() + " " + peoples[i].price);
                return;
            }
        }
    }

    static class People implements Comparable<People> {
        Queue<String> names;
        int price;

        People(int price) {
            this.names = new LinkedList<>();
            this.price = price;
        }

        @Override
        public int compareTo(People o) {
            if (this.names.size() == o.names.size()) {
                return this.price - o.price;
            }
            return this.names.size() - o.names.size();
        }
    }
}
