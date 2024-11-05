package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16506 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, String> map = new HashMap<String, String>();
        map.put("ADD", "0000");
        map.put("SUB", "0001");
        map.put("MOV", "0010");
        map.put("AND", "0011");
        map.put("OR", "0100");
        map.put("NOT", "0101");
        map.put("MULT", "0110");
        map.put("LSFTL", "0111");
        map.put("LSFTR", "1000");
        map.put("ASFTR", "1001");
        map.put("RL", "1010");
        map.put("RR", "1011");

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            int rB = Integer.parseInt(st.nextToken());

            if (op.charAt(op.length() - 1) == 'C') {
                sb.append(map.get(op.substring(0, op.length() - 1))).append("1");
            } else {
                sb.append(map.get(op)).append("0");
            }
            sb.append("0");

            String binary = Integer.toBinaryString(rD);
            sb.append(makeBinary(0, binary, 2));
            if (op.equals("NOT") || op.equals("MOV") || op.equals("MOVC")) {
                sb.append("000");
            } else {
                String binary1 = Integer.toBinaryString(rA);
                sb.append(makeBinary(0, binary1, 2));
            }

            String binary2 = Integer.toBinaryString(rB);
            if (op.charAt(op.length() - 1) == 'C') {
                sb.append(makeBinary(0, binary2, 3));
            } else {
                sb.append(makeBinary(0, binary2, 2)).append("0");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String makeBinary(int depth, String str, int limit) {
        if (depth >= limit || limit < str.length()) {
            return str;
        }
        return makeBinary(depth + 1, "0" + str, limit);
    }
}
