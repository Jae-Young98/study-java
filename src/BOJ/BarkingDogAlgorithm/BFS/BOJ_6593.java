package BOJ.BarkingDogAlgorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
    static int h, n, m;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Node s;
    static Node e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (h == 0 && n == 0 && m == 0) {
                break;
            }

            map = new char[h][n][m];
            visited = new boolean[h][n][m];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < m; k++) {
                        char c = str.charAt(k);
                        map[i][j][k] = c;
                        if (c == 'S') {
                            s = new Node(i, j, k, 0);
                        } else if (c == 'E') {
                            e = new Node(i, j, k, 0);
                        }
                    }
                }
                String str = br.readLine();
            }
            int result = bfs();
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(s.z, s.x, s.y, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.z == e.z && node.x == e.x && node.y == e.y) {
                return node.cnt;
            }

            for (int i = 0; i < 6; i++) {
                int nz = node.z + dz[i];
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nz >= 0 && nz < h && nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nz][nx][ny] && map[nz][nx][ny] != '#') {
                        visited[nz][nx][ny] = true;
                        queue.offer(new Node(nz, nx, ny, node.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {
        int z;
        int x;
        int y;
        int cnt;

        Node(int z, int x, int y, int cnt) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
