package Programmers.Lv_1;

public class 히샤드_수 {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        String[] nums = String.valueOf(x).split("");
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
        }

        if (x % sum == 0) {
            return true;
        }

        return false;
    }
}
