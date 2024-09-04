package math;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        String s = "ABC";
        int count = 2; // 뽑고자하는 조합의 개수
        combination(0, s.toCharArray(), "", count);
        System.out.println(resultList);
    }

    public static void combination(int idx, char[] order, String result, int count) {
        if (result.length() == count) {
            resultList.add(result);
        }
        System.out.println("result = " + result);
        for (int i = idx; i < order.length; i++) {
            combination(i + 1, order, result + order[i], count);
        }
    }
}
