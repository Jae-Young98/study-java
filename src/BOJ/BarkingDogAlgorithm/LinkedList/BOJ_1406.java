package BOJ.BarkingDogAlgorithm.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int n = str.length(); // 커서
        int m = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();
            if (cmd.charAt(0) == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (cmd.charAt(0) == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (cmd.charAt(0) == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (cmd.charAt(0) == 'P') {
               iter.add(cmd.charAt(2));
            }
        }

        for(Character c : list){
            bw.write(c);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
