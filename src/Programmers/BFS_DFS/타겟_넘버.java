package Programmers.BFS_DFS;

public class 타겟_넘버 {
    static class Solution {

        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(0, 0, numbers, target);

            return answer;
        }

        private void dfs(int sum, int depth, int[] numbers, int target) {
            if (depth == numbers.length && sum == target) {
                answer++;
                return;
            }

            if (depth >= numbers.length) {
                return;
            }

            dfs(sum - numbers[depth], depth + 1, numbers, target);
            dfs(sum + numbers[depth], depth + 1, numbers, target);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Solution solution = new Solution();
        int result = solution.solution(numbers, target);

        System.out.println(result);
    }
}
