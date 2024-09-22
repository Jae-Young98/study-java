package BOJ.PrepareCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16165 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> memberGroup = new HashMap<>();
        Map<String, List<String>> groupMember = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String group = br.readLine();
            groupMember.put(group, new ArrayList<>());

            int member = Integer.parseInt(br.readLine());
            for (int j = 0; j < member; j++) {
                String name = br.readLine();
                memberGroup.put(name, group);

                List<String> members = groupMember.get(group);
                members.add(name);
                groupMember.put(group, members);
            }
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            if (quiz == 0) {
                List<String> members = groupMember.get(str);
                Collections.sort(members);

                for (String member : members) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(memberGroup.get(str)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
