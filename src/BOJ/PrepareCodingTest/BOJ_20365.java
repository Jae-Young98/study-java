import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20365 {
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int r = 0;
		int b = 0;
		char before = 'x';
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			if (c != before) {
				if (c == 'r') {
					r++;
				} else {
					b++;
				}
			}
			before = c;
		}

		System.out.println(Math.min(r, b) + 1);
	}
}
