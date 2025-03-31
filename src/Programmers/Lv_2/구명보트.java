package Programmers.Lv_2;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int bothSafeCount = 0;
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
                bothSafeCount++;
            } else {
                r--;
            }
        }

        return people.length - bothSafeCount;
    }
}
