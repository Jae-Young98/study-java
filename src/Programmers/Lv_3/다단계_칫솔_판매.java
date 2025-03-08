package Programmers.Lv_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {

    static Map<String, String> tree = new HashMap<>();
    static Map<String, Integer> money = new HashMap<>();

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            shareMoney(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = money.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    static void shareMoney(String node, int sales) {
        int next = sales / 10;
        money.put(node, money.getOrDefault(node, 0) + sales - next);

        if (next > 0 && tree.containsKey(node)) {
            shareMoney(tree.get(node), next);
        }
    }
}
