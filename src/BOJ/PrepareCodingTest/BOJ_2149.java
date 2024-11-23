package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class BOJ_2149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String key = br.readLine();
        String pwd = br.readLine();

        char[][] arr = new char[(pwd.length() / key.length()) + 1][key.length()];
        char[] keyArr = new char[key.length()];
        char[] sortedKeyArr = new char[key.length()];
        for (int i = 0; i < key.length(); i++) {
            sortedKeyArr[i] = key.charAt(i);
            keyArr[i] = key.charAt(i);
        }

        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            for (int j = 1; j <= (pwd.length() / key.length()); j++) {
                arr[j][i] = pwd.charAt(index);
                index++;
            }
        }

        Arrays.sort(keyArr);
        for (int i = 0; i < key.length(); i++) {
            arr[0][i] = keyArr[i];
        }

        boolean[] visited = new boolean[key.length()];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < key.length(); j++) {
                for (int k = 0; k < key.length(); k++) {
                    if (!visited[k] && sortedKeyArr[j] == arr[0][k]) {
                        visited[k] = true;
                        sb.append(arr[i][k]);
                        break;
                    }
                }
            }
            for (int k = 0; k < key.length(); k++) {
                visited[k] = false;
            }
        }
        System.out.println(sb);
    }
}