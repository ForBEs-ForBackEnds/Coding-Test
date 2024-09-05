package hash.메뉴_리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static Map<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {

        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            // 각 문자열(order)에 대한 조합을 만든다.
            // 대신 order의 길이는 course에 들어있는 값으로만 구성된다.
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray); // 오름차순 정렬 중요!! ex) AB 와 BA는 같은 조합이기 때문
            combination(0, orderArray, "");
        }

        List<String> answer = new ArrayList<>();

        for (HashMap<String, Integer> countMap : courseMap.values()) {
            // 1. 각 countMap의 Value 중 최대 값을 구한다.
            int maxCount = countMap.values().stream()
                                   .max(Comparator.comparingInt(i -> i))
                                   .orElse(0);
            if (maxCount < 2) { // 조합의 빈도 수가 최소 2여야 함.
                continue;
            }

            // 2. 최대값을 만족하는 entry를 가져온다.
            countMap.entrySet().stream()
                .filter(e -> e.getValue() == maxCount)
                .forEach(e ->answer.add(e.getKey()));
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public static void combination(int idx, char[] orderArray, String result) {
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < orderArray.length; i++) {
            combination(i + 1, orderArray, result + orderArray[i]);
        }
    }
}
