package hash.완주하지_못한_선수;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Wrong_Solution {

    /**
     * 이 문제가 백준 3273과 달리 Set을 쓰면 안되는 이유(= 잘못된 코드인 이유)
     * : 백준 3273은 중복되는 원소가 없기 때문에 Set을 써도 가능하다.
     *   하지만 이 문제는 중복되는 값이 들어있을 수 있으므로, 완주자 명단을 저장할 때 Set을 사용하면 안된다.
     *   만약, 참여자가 ["A", "A", "B"]이고 완주자가 ["A", "A"]일 때
     *   미완주자는 "B"임에도 불구하고, 해당 코드를 실행했을 때 "A"가 반환된다.
     *   그 이유는 완주자인 "A", "A"가 Set에 저장되면 중복 값이 허용되지 않아 "A"가 하나만 저장되기 때문이다!!!
     */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Set<String> completions = new HashSet<>(Arrays.asList(completion));
        for (String people : participant) {
            if (completions.contains(people)) {
                completions.remove(people); // 동명이인이 있을 수 있으므로, 찾으면 바로 제거하기!
            } else {
                answer = people; // if 문을 만족하지 못하면 미완주자로 등록 후 종료
                break;
            }
        }
        return answer;
    }
}
