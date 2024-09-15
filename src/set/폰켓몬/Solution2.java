package set.폰켓몬;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution2 {

    public int solution(int[] nums) {

        HashSet<Integer> set = Arrays.stream(nums)
                                     .boxed()
                                     .collect(Collectors.toCollection(HashSet::new));
        int n = nums.length;
        int k = n / 2;
        return Math.min(k, set.size());
    }
}
