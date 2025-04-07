package Programmers.Lv_2;

import java.util.Arrays;

public class 이진_변환_반복하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
        System.out.println(Arrays.toString(solution("01")));
    }

    public static int[] solution(String s) {
        int changeCount = 0;
        int removeCount = 0;

        while (true) {
            if (s.equals("1")) {
                break;
            }

            int currentLen = s.length();

            s = s.replace("0", "");
            int afterRemoveLen = s.length();

            removeCount += (currentLen - afterRemoveLen);

            s = Integer.toBinaryString(afterRemoveLen);
            changeCount++;
        }

        return new int[]{changeCount, removeCount};
    }
}
