package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[1001][1001]; // clip, emoji
        Queue<Emoji> queue = new LinkedList<>();
        queue.offer(new Emoji(0, 1, 0));
        visited[0][1] = true;

        while (!queue.isEmpty()) {
            Emoji now = queue.poll();

            if (now.total == s) {
                System.out.println(now.time);
                return;
            }

            // 1. 화면에 있는 이모티콘들을 클립보드에 모두 저장
            queue.offer(new Emoji(now.total, now.total, now.time + 1));

            // 2. 이모티콘 붙여넣기
            // 클립보드는 비어있지 않아야하고 붙여넣은 후 개수는 총 개수보다 적어야하고 방문한적 없어야함
            if (now.clipboard != 0 && now.total + now.clipboard <= s && !visited[now.clipboard][now.total + now.clipboard]) {
                queue.offer(new Emoji(now.clipboard, now.total + now.clipboard, now.time + 1));
                visited[now.clipboard][now.total + now.clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 한 개 삭제
            // 1 이상, 방문한적 없어야함
            if (now.total >= 1 && !visited[now.clipboard][now.total - 1]) {
                queue.offer(new Emoji(now.clipboard, now.total - 1, now.time + 1));
                visited[now.clipboard][now.total - 1] = true;
            }
        }
    }

    public static class Emoji {
        int clipboard;
        int total;
        int time;

        Emoji(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
