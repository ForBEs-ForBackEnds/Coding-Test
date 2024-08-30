package hash.할인_행사;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = 10; // 총 물품 개수 = 할인 기간
        Map<String, Integer> productInfo = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            productInfo.put(want[i], number[i]);
        }

        Map<String, Integer> cloneInfo;
        A:for (int i = 0; i + (n - 1) < discount.length; i++) {
            cloneInfo = new HashMap<>(productInfo);
            for (int j = i; j <= i + (n - 1); j++) {
                String name = discount[j];
                if (cloneInfo.getOrDefault(name, 0) == 0) {
                    continue A;
                }
                cloneInfo.put(name, cloneInfo.get(name) - 1);
            }
            answer++;
        }
        return answer;
    }
}
