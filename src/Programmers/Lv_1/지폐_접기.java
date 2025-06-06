package Programmers.Lv_1;

public class 지폐_접기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{30, 15}, new int[]{26, 17}));
        System.out.println(solution(new int[]{50, 50}, new int[]{100, 241}));
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if ((bill[0] <= wallet[0] && bill[1] <= wallet[1])
                    || (bill[1] <= wallet[0] && bill[0] <= wallet[1])) {
                break;
            }

            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }

            answer++;
        }

        return answer;
    }
}
