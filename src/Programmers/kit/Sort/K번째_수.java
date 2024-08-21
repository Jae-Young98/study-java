package Programmers.kit.Sort;

import java.util.Arrays;

public class K번째_수 {

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int cmdLength = commands.length;
            int[] answer = new int[cmdLength];

            int i;
            int j;
            int k;
            for (int c = 0; c < cmdLength; c++) {
                i = commands[c][0] - 1;
                j = commands[c][1] - 1;
                k = commands[c][2] - 1;
                int[] arr = new int[j - i + 1];

                int idx = 0;
                for (int x = i; x <= j; x++) {
                    arr[idx] = array[x];
                    idx++;
                }

                Arrays.sort(arr);
                answer[c] = arr[k];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();

        int[] result = solution.solution(array, commands);

        System.out.println(Arrays.toString(result));
    }
}
