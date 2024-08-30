package hash.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completions = new HashMap<>();
        for (String c : completion) {
            completions.put(c, completions.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
//            if (!completions.containsKey(p) || completions.get(p) == 0) {
//                answer = p;
//                break;
//            }
            if (completions.getOrDefault(p, 0) == 0) {
                answer = p;
                break;
            }
            completions.put(p, completions.get(p) - 1);
        }
        return answer;
    }
}
