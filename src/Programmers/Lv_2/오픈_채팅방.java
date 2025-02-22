package Programmers.Lv_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈_채팅방 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        StringTokenizer st;
        Map<String, String> map = new HashMap<>();

        int change = 0;
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);

            String command = st.nextToken();
            String id = st.nextToken();
            if (command.equals("Enter")) {
                String nickname = st.nextToken();
                map.put(id, nickname);
            } else if (command.equals("Change")) {
                String nickname = st.nextToken();
                map.put(id, nickname);
                change++;
            }
        }

        String[] answer = new String[record.length - change];
        int index = 0;
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);

            String command = st.nextToken();
            String id = st.nextToken();
            String nickname = map.get(id);

            if (command.equals("Enter")) {
                answer[index] = nickname + "님이 들어왔습니다.";
                index++;
            } else if (command.equals("Leave")) {
                answer[index] = nickname + "님이 나갔습니다.";
                index++;
            }
        }
        return answer;
    }
}
