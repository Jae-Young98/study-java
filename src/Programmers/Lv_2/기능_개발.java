package Programmers.Lv_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 기능_개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();

        int n = progresses.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int cnt = 0;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] <= max) {
                cnt++;
            } else {
                queue.add(cnt);
                cnt = 1;
                max = arr[i];
            }
        }

        queue.add(cnt);
        return queue.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
