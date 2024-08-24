package queue.기능개발;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();

        int[] daysLeft = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); // 소수점 올리기 : Math.ceil()
        }

        int count = 0;
        int maxDay = daysLeft[0]; // 맨 앞에 있는 기능이 100%가 되는 날짜

        for (int i = 0; i < progresses.length; i++) {
            if (daysLeft[i] <= maxDay) {
                count++;
            } else { // 더이상 배포할 수 있는게 없을 때
                queue.offer(count);
                count = 1;
                maxDay = daysLeft[i]; // if 조건을 만족하지 않는 순서에 있는 기능이 그 다음으로 먼저 배포되는 기능임
            }
        }

        queue.offer(count); // 배포되지 않은 나머지 기능들도 추가, Queue가 아닌 List를 사용해도 됨. Queue라는 형태에 얽매이지 말것
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
