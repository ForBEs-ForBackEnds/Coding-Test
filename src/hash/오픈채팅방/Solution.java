package hash.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        Map<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        // 이름 업데이트
        for (String s : record) {
            String[] split = s.split(" ");
            if (split.length == 3) {
                nameMap.put(split[1], split[2]);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            String id = split[1];
            if (msg.containsKey(command)) {
                answer.add(nameMap.get(id) + msg.get(command));
            }
        }

        return answer.toArray(new String[0]);
    }
}
