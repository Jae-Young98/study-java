package Programmers.Lv_1;

public class 동영상_재생기 {

    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenInt = strToSec(video_len);
        int posInt = strToSec(pos);
        int opStartInt = strToSec(op_start);
        int opEndInt = strToSec(op_end);

        for (String command : commands) {
            if (posInt >= opStartInt && posInt <= opEndInt) {
                posInt = opEndInt;
            }

            if (command.equals("next")) {
                posInt += 10;
            } else {
                posInt -= 10;
            }

            if (posInt >= opStartInt && posInt <= opEndInt) {
                posInt = opEndInt;
            }

            if (posInt > videoLenInt) {
                posInt = videoLenInt;
            } else if (posInt < 0) {
                posInt = 0;
            }
        }

        int min = posInt / 60;
        posInt %= 60;

        StringBuilder sb = new StringBuilder();
        if (min < 10) {
            sb.append(0).append(min).append(":");
        } else {
            sb.append(min).append(":");
        }

        if (posInt < 10) {
            sb.append(0).append(posInt);
        } else {
            sb.append(posInt);
        }
        return sb.toString();
    }

    public static int strToSec(String str) {
        int minToSec = Integer.parseInt(str.substring(0, 2)) * 60;
        return minToSec + Integer.parseInt(str.substring(3));
    }
}
