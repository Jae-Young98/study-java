package Programmers.Lv_1;

import java.util.Arrays;

public class 데이터_분석 {

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        System.out.println(Arrays.deepToString(solution(data, ext, val_ext, sort_by)));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int filter = getFilterIndex(ext);

        return Arrays.stream(data)
                .filter(x -> x[filter] < val_ext)
                .sorted((o1, o2) -> o1[getFilterIndex(sort_by)] - o2[getFilterIndex(sort_by)])
                .toArray(int[][]::new);
    }

    private static int getFilterIndex(String ext) {
        if (ext.equals("code")) {
            return 0;
        } else if (ext.equals("date")) {
            return 1;
        } else if (ext.equals("maximum")) {
            return 2;
        }

        return 3;
    }
}
