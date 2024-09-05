package stream.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxExample1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 3, 45, 7, 12);

        int maxNumber = numbers.stream()
                               .max(Comparator.comparingInt(num -> num))
                               .orElseThrow();

        System.out.println("가장 큰 숫자 : " + maxNumber);
    }
}
