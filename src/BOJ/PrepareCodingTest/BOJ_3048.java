package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Ant[] groupA = new Ant[a];
        Ant[] groupB = new Ant[b];

        String str = br.readLine();
        for (int i = a - 1; i >= 0; i--) {
            groupA[i] = new Ant('A', str.charAt(a - i - 1));
        }

        str = br.readLine();
        for (int i = 0; i < b; i++) {
            groupB[i] = new Ant('B', str.charAt(i));
        }

        Ant[] arr = new Ant[a + b];
        for (int i = 0; i < a; i++) {
            arr[i] = groupA[i];
        }

        for (int i = a; i < a + b; i++) {
            arr[i] = groupB[i - a];
        }

        int t = Integer.parseInt(br.readLine());
        Ant[] result = arr;
        for (int i = 0; i < t; i++) {
            Ant[] now = result.clone();
            for (int j = 0; j < a + b - 1; j++) {
                if (now[j].group != now[j + 1].group) {
                    Ant temp = now[j];
                    result[j] = now[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < a + b; i++) {
            sb.append(result[i].name);
        }

        System.out.println(sb);
    }

    static class Ant {
        char group;
        char name;

        Ant(char group, char name) {
            this.group = group;
            this.name = name;
        }
    }
}
