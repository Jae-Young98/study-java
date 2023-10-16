package BOJ.BarkingDogAlgorithm.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {

    static int[] light;
    static int n, student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        light = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int lightNum = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                isBoy(lightNum);
            } else {
                isGirl(lightNum);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(light[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void isBoy(int lightNum) {
        for (int i = lightNum; i <= n; i += lightNum) {
            if (light[i] == 1) {
                light[i] = 0;
            } else {
                light[i] = 1;
            }
        }
    }

    public static void isGirl(int lightNum) {
        int left = lightNum - 1;
        int right = lightNum + 1;

        while (left >= 1 && right <= n) {
            if (light[left] != light[right]) {
                break;
            }
            left--;
            right++;
        }
        left++;
        right--;

        for (int i = left; i <= right; i++) {
            if (light[i] == 0) {
                light[i] = 1;
            } else {
                light[i] = 0;
            }
        }
    }
}
