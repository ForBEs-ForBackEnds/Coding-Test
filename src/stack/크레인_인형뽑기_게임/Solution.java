package stack.크레인_인형뽑기_게임;

import java.util.ArrayDeque;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer>[] stacks = new ArrayDeque[board.length];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new ArrayDeque<>();
        }
        ArrayDeque<Integer> basket = new ArrayDeque<>();

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    stacks[j].push(board[i][j]);
                }
            }
        }

        for (int move : moves) {
            if (!stacks[move - 1].isEmpty()) {
                int doll = stacks[move - 1].pop();
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
            }
        }
        return answer;
    }
}
