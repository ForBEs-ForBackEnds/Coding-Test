package stream.max;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxExample4 {

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("apple", 5);
        wordCount.put("banana", 2);
        wordCount.put("watermelon", 8);
        wordCount.put("kiwi", 3);

        Entry<String, Integer> mostFrequentWord = wordCount.entrySet().stream()
                                                           .max(Comparator.comparingInt(Entry::getValue))
                                                           .orElseThrow();

        System.out.println("가장 많이 등장한 단어 : " + mostFrequentWord.getKey());
        System.out.println("빈도 수 : " + mostFrequentWord.getValue());
    }
}
