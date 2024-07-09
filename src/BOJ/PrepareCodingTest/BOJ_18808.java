package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18808 {

    static int N;
    static int M;
    static int K;
    static int R;
    static int C;
    static int result = 0;
    static int[][] arr;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        // 1. 스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
        // 2. 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다.
        // 혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다.
        // 가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
        // 3. 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
        // 4. 위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 버린다.

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new int[R][C];
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            find();
        }

        System.out.println(result);
    }

    public static void find() {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int d = 0; d < 4; d++) {
            if (d != 0) {
                sticker = rotate(r, c);
            }
            r = sticker.length;
            c = sticker[0].length;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i + r > N || j + c > M) {
                        break;
                    }

                    if (attach(i, j, r, c)) {
                        return;
                    }
                }
            }
        }

    }

    public static int[][] rotate(int r, int c) {
        int[][] temp = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[j][r - i - 1] = sticker[i][j];
            }
        }

        return temp;
    }

    public static boolean attach(int x, int y, int r, int c) {
        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + c; j++) {
                if (arr[i][j] == 1 && sticker[i - x][j - y] == 1) {
                    return false;
                }
            }
        }

        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + c; j++) {
                if (sticker[i - x][j - y] == 1) {
                    arr[i][j] = 1;
                    result++;
                }
            }
        }

        return true;
    }
}
