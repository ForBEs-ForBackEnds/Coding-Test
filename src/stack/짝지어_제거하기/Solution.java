package stack.짝지어_제거하기;

import java.util.ArrayDeque;

class Solution {

    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
