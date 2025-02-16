package Programmers.Lv_3;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 표_편집 {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] arr = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(solution(n, k, arr));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        k++;

        for (String c : cmd) {
            StringTokenizer st = new StringTokenizer(c);
            String command = st.nextToken();

            if (command.equals("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                if (n < down[k]) {
                    k = up[k];
                } else {
                    k = down[k];
                }
            } else if (command.equals("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                int x = Integer.parseInt(st.nextToken());
                for (int i = 0; i < x; i++) {
                    if (command.equals("U")) {
                        k = up[k];
                    } else {
                        k = down[k];
                    }
                }
            }
        }
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
