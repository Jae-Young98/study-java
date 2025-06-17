package Programmers.Lv_2;

import java.util.LinkedList;
import java.util.Queue;

public class 서버_증설_횟수 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},
				3, 5));
		System.out.println(solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},
				5, 1));
		System.out.println(solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
				1, 1));
	}

	public static int solution(int[] players, int m, int k) {
		Queue<Integer> queue = new LinkedList<>();

		int answer = 0;
		for (int i = 0; i < players.length; i++) {
			while (!queue.isEmpty() && queue.peek() == i) {
				queue.poll();
			}

			int playerCount = players[i];
			if (playerCount / m <= queue.size()) {
				continue;
			}

			int n = (playerCount / m) - queue.size();
			for (int j = 0; j < n; j++) {
				queue.add(i + k);
				answer++;
			}
		}

		return answer;
	}
}
