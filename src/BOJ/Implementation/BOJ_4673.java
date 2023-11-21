package BOJ.Implementation;

import java.io.IOException;
import java.util.Arrays;

public class BOJ_4673 {
    public static void main(String[] args) throws IOException {
        boolean[] selfNumbers = new boolean[10001];
        Arrays.fill(selfNumbers, true);

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {
                selfNumbers[n] = false;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (selfNumbers[i]) {
                System.out.println(i);;
            }
        }
    }

    public static int d(int number) {
        int sum = number;

         while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }

        return sum;
    }

}
