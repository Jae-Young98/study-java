package Programmers.Lv_2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {

    static Set<Integer> set;
    static boolean[] visited = new boolean[7];

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();

        dfs(numbers, "", 0);

        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(String numbers, String s, int depth) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        // 에라토스테네스 체
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
