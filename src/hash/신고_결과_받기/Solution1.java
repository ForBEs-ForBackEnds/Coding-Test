package hash.신고_결과_받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution1 {

    // 유저가 몇 명한테 신고를 "당했는지"에 중점을 두고 설계한 자료구조
    private static Map<String, Set<String>> reportedUser = new HashMap<>();
    private static Map<String, Integer> reportCount = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        for (String r : report) {
            String[] split = r.split(" ");
            String userId = split[0];
            String reportedId = split[1];

            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            reportedUser.get(reportedId).add(userId);
        }

        for (Entry<String, Set<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String userId : entry.getValue()) {
                    reportCount.put(userId, reportCount.getOrDefault(userId, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
