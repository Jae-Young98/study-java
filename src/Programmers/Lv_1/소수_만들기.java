package Programmers.Lv_1;

import java.util.Arrays;

public class 소수_만들기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }

    public static int solution(int[] nums) {
        boolean[] prime = new boolean[3001];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(3000); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 3000; j += i) {
                    prime[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int x = nums[i] + nums[j] + nums[k];

                    if (prime[x]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
