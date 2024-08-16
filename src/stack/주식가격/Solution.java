package stack.주식가격;

import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 2, 3});
    }

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = (prices.length - 1) - pop;
        }

//        if (!stack.isEmpty()) {
//            for (Integer i : stack) {
//                answer[i] = (answer.length - 1) - i;
//            }
//        }
        return answer;
    }
}
