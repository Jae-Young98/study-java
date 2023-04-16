package BOJ.intensify1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_252026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] str = new String[20];
        String[] gradeArr = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double[] gradeScore = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
        double gradeSum = 0;
        double scoreSum = 0;

        for (int i = 0; i < 20; i++) {
            str[i] = br.readLine();
            st = new StringTokenizer(str[i], " ");
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            for (int j = 0; j < 10; j++) {
                if (grade.equals(gradeArr[j])) {
                    gradeSum += gradeScore[j] * score;
                    if (j != 9) {
                        scoreSum += score;
                    }
                }
            }
        }

        double avg = gradeSum / scoreSum;
        System.out.printf("%.6f\n", avg);

        br.close();
    }
}
