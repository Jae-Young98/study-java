package Programmers.Lv_1;

public class 이웃한_칸 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}}, 1, 1));

        System.out.println(solution(new String[][]{
                {"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}}, 0, 1));
    }

    public static int solution(String[][] board, int h, int w) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        String color = board[h][w];

        int n = board.length;
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + h;
            int ny = dy[i] + w;

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (board[nx][ny].equals(color)) {
                answer++;
            }
        }

        return answer;
    }
}
