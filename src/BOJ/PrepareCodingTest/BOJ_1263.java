package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1263 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<Work> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new Work(t, s));
		}

		Collections.sort(list);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			Work work = list.get(i);
			result = Math.min(result, work.s) - work.t;

			if (result < 0) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(result);
	}

	static class Work implements Comparable<Work> {
		int t;
		int s;

		Work(int t, int s) {
			this.t = t;
			this.s = s;
		}

		@Override
		public int compareTo(Work o) {
			return o.s - this.s;
		}
	}
}
