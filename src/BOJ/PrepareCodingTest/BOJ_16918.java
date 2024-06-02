package BOJ.PrepareCodingTest;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16918 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Point> list = new ArrayList<>();
        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                if(temp.charAt(j) == 'O') list.add(new Point(i,j));
                arr[i][j] = temp.charAt(j);
            }
        }

        if(N==1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            return;
        }

        if(N%2==0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print("O");
                }
                System.out.println();
            }
            return;
        }

        while(N>=3) {
            list.clear();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(arr[i][j]=='O') list.add(new Point(i,j));
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] = 'O';
                }
            }

            for (int i = 0; i < list.size(); i++) {
                arr[list.get(i).x][list.get(i).y] = '.';
                for(int j=0; j<4; j++) {
                    int nx = list.get(i).x + dx[j];
                    int ny = list.get(i).y + dy[j];
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C) arr[nx][ny] = '.';
                }
            }

            N = N-2;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
