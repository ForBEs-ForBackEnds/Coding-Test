package stack.괄호_회전하기;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<Character, Character> map = new HashMap<>();
    /**
     * x는 0부터 s.length() - 1까지
     * 올바른 괄호를 판단하는 로직은 이전과 동일
     * 다만, 회전시켰을 때의 문자열을 어떻게 구성할 것인지가 관건
     * -> StringBuilder를 사용해서 문자열을 조작?
     */
    public int solution(String s) {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        /**
         * 0부터 s.length() - 1까지 반복한다. - while문
         * 만약 올바른 괄호일 경우, count ++;
         * 올바르지 않을 경우, continue;
         */
        int x = 0;
        int result = 0;
        StringBuilder sb = new StringBuilder(s);
        while (x < s.length()) {
            // 괄호를 회전한다.
            final char removedChar = sb.charAt(0);
            final StringBuilder modifiedSb = sb.deleteCharAt(0).append(removedChar);
            if (isCorrect(modifiedSb.toString())) {
                result += 1;
            }
            x++;
        }
        return result;
    }

    private boolean isCorrect(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                // 닫힌괄호가 왔는데, 스택이 비어있거나 맞는 짝이 없을 경우 false;
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        // 루프가 끝났을 때, 스택에 열린 괄호가 남아있을 경우에도 false;
        return stack.isEmpty();
    }
}
