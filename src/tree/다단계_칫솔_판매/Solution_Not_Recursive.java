package tree.다단계_칫솔_판매;

import java.util.HashMap;
import java.util.Map;

public class Solution_Not_Recursive {

    private static Map<String, Integer> revenueTable = new HashMap<>();
    private static Map<String, String> superiorTable = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            superiorTable.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !sellerName.equals("-")) {
                revenueTable.put(sellerName, revenueTable.getOrDefault(sellerName, 0) + money - (money / 10));
                sellerName = superiorTable.get(sellerName); // 부모 이름으로 변경 + while문 => 재귀문 안 써도 됨.
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            answer[i] = revenueTable.getOrDefault(name, 0);
        }

        return answer;
    }
}
