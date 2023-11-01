package BOJ.BarkingDogAlgorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MONEY = 1000;
        int count = 0;
        int[] changes = {500, 100, 50, 10, 5, 1};

        int pay = Integer.parseInt(br.readLine());
        pay = MONEY - pay;
        for (int change : changes) {
            if (pay / change > 0) {
                count += pay / change;
                pay %= change;
            }
        }

        System.out.println(count);
    }
}
