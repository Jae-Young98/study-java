package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3613 {

    static StringBuilder sb;
    static boolean isAllLower;
    static String lang;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(br.readLine());

        if (!(isCpp() && isJava() && validate())) {
            System.out.println("Error!");
            return;
        }

        if (isAllLower) {
            System.out.println(sb.toString());
            return;
        }

        if (lang.equals("CPP")) {
            convertCppToJava();
        } else {
            convertJavaToCpp();
        }

        System.out.println(sb.toString());
    }

    private static boolean isCpp() {
        if (sb.charAt(sb.length() - 1) == '_') {
            return false;
        } else if (sb.charAt(0) == '_') {
            return false;
        } else if (sb.indexOf("__") >= 0) {
            return false;
        }

        return true;
    }

    private static boolean isJava() {
        return !(sb.charAt(0) >= 'A' && sb.charAt(0) <= 'Z');
    }

    private static boolean validate() {
        boolean isUpper = false;
        boolean isUnder = false;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c >= 'A' && c < 'Z') {
                isUpper = true;
            } else if (c == '_') {
                isUnder = true;
            }
        }

        if (!isUnder && !isUpper) {
            isAllLower = true;
        } else {
            isAllLower = false;
        }

        if (((isUnder && !isUpper) || (!isUnder && isUpper)) || isAllLower) {
            if (isUnder) {
                lang = "CPP";
            } else {
                lang = "JAVA";
            }

            return true;
        } else {
            return false;
        }
    }

    private static void convertCppToJava() {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '_') {
                sb.deleteCharAt(i);
                sb.replace(i + 1, i + 1, String.valueOf(sb.charAt(i)).toUpperCase());
                sb.deleteCharAt(i);
            }
        }
    }

    private static void convertJavaToCpp() {
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                sb.replace(i, i + 1, String.valueOf(c).toLowerCase());
                sb.insert(i, "_");
            }
        }
    }
}
