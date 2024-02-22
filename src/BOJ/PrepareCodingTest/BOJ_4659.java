package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr;
        boolean isAccept;
        int isContinue;
        char prevCh;
        while (true) {
            String str = br.readLine();
            arr = str.toCharArray();

            if (str.equals("end")) {
                return;
            }

            isAccept = false;
            isContinue = 0;
            prevCh = '.';
            for (char c : arr) {
                if (isVowel(c)) {
                    isAccept = true;
                }

                if (isVowel(c) != isVowel(prevCh)) {
                    isContinue = 1;
                } else {
                    isContinue++;
                }

                if (isContinue > 2 || prevCh == c && c != 'e' && c != 'o') {
                    isAccept = false;
                    break;
                }

                prevCh = c;
            }

            if (isAccept) {
                System.out.println("<" + str + "> " + "is acceptable.");
            } else {
                System.out.println("<" + str + "> " + "is not acceptable.");
            }
        }
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
