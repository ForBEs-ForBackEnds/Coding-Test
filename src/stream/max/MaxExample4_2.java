package stream.max;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MaxExample4_2 {

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("apple", 5);
        wordCount.put("banana", 2);
        wordCount.put("watermelon", 8);
        wordCount.put("kiwi", 8);

        // 최대값을 갖는 요소가 두 개일 경우, 첫 번째로 찾은 watermelon만 반환한다.
        // 따라서 최대값을 갖는 요소를 모두 가져오려면, 두 단계로 나눠서 생각해야 한다.

        // 1. 최대 값을 구한다.
        int maxCount = wordCount.values().stream()
                                .max(Comparator.comparingInt(o -> o))
                                .orElseThrow();

        // 2. 최대 값을 만족하는 요소만 가져온다.
        List<Entry<String, Integer>> mostFrequentWords = wordCount.entrySet().stream()
                                                     .filter(e -> e.getValue() == maxCount)
                                                     .collect(Collectors.toList());

        System.out.println("가장 많이 등장한 단어들:");
        for (Entry<String, Integer> entry : mostFrequentWords) {
            System.out.println(entry.getKey() + " (빈도 수: " + entry.getValue() + ")");
        }
    }
}
