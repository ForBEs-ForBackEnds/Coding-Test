package stream.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxExample2 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "watermelon", "kiwi");

        String longestString = strings.stream()
                                      .max(Comparator.comparingInt(s -> s.length()))
                                      .orElseThrow();

        System.out.println("가장 긴 문자열 : " + longestString);
    }
}
