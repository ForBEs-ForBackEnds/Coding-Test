package tree.다단계_칫솔_판매;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<String, Integer> revenueTable = new HashMap<>();
    private static Map<String, String> superiorTable = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            superiorTable.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int result = amount[i] * 100;
            distribute(sellerName, result);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            answer[i] = revenueTable.getOrDefault(name, 0);
        }

        return answer;
    }

    private static void distribute(String sellerName, int amount) {
        int distribution = amount / 10;
        revenueTable.put(sellerName, revenueTable.getOrDefault(sellerName, 0) + amount - distribution);
        if (distribution < 1) {
            return;
        }
        distribute(superiorTable.getOrDefault(sellerName, "center"), distribution);
    }
}
