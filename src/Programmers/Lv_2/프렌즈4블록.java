package Programmers.Lv_2;

public class 프렌즈4블록 {

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            boolean[][] sameMap = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];

                    // 오른쪽, 오른쪽 아래, 아래
                    if (map[i][j + 1] == c && map[i + 1][j + 1] == c
                            && map[i + 1][j] == c) {
                        sameMap[i][j] = true;
                        sameMap[i][j + 1] = true;
                        sameMap[i + 1][j + 1] = true;
                        sameMap[i + 1][j] = true;
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    if (!sameMap[i][j]) {
                        continue;
                    }

                    if (sameMap[i][j] && map[i][j] != '-') {
                        cnt++;
                        map[i][j] = '-';
                    }
                }
            }

            if (cnt == 0) {
                break;
            }
            answer += cnt;

            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '-') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != '-') {
                                map[i][j] = map[k][j];
                                map[k][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
