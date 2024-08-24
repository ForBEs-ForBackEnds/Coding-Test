package queue.카드_뭉치;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";

        // String[]을 List<String>으로 변환한 후, 바로 Queue에 데이터를 추가한다. (향상된 for문 사용X)
        Queue<String> cardQueue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cardQueue2 = new ArrayDeque<>(Arrays.asList(cards2));

        // cards1과 cards2를 각각 Queue에 담는다.
//        for (String card : cards1) {
//            cardQueue1.offer(card);
//        }
//        for (String card : cards2) {
//            cardQueue2.offer(card);
//        }

        for (int i = 0; i < goal.length; i++) {
            if (!cardQueue1.isEmpty() && cardQueue1.peek().equals(goal[i])) {
                cardQueue1.poll();
            } else if (!cardQueue2.isEmpty() && cardQueue2.peek().equals(goal[i])) {
                cardQueue2.poll();
            } else {
                return answer;
            }
        }
        answer = "Yes";
        return answer;
    }
}
