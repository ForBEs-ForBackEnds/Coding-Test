package stream.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxExample3 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 24),
            new Person("Charlie", 35)
        );

        Person oldestPeople = people.stream()
                                    .max(Comparator.comparingInt(p -> p.age))
                                    .orElseThrow();

        /**
         * max에 전달된 Comparator 값 기준으로 최댓값을 갖는 요소를 반환하는 것임.
         */

        System.out.println("가장 나이 많은 사람 " + oldestPeople);
    }
}

class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public int getAge() {
        return age;
    }
}
