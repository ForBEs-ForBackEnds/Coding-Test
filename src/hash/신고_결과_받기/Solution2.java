package hash.신고_결과_받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    // 유저가 몇 명을 신고 "했는지"에 중점을 두고 설계한 자료구조
    // 해당 문제는 누가 몇 명한테 신고를 "당했는지"가 더 중요하기 때문에 Solution1의 코드가 더욱 깔끔할 수밖에 없음.
    private static Map<String, Set<String>> reportRecord = new HashMap<>();
    private static Map<String, Integer> reportCount = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        // ID 별 신고횟수 및 이력 초기화
        for (String id : id_list) {
            reportCount.put(id, 0);
            reportRecord.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String respondent = split[1];
            Set<String> respondents = reportRecord.get(reporter);

            if (respondents.contains(respondent)) {
                continue;
            }
            reportCount.put(respondent, reportCount.get(respondent) + 1);
            respondents.add(respondent); // 중복이 있으면 안되기 때문에 List가 아니라 Set을 사용
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            Set<String> respondents = reportRecord.get(id_list[i]);
            int count = 0;
            for (String respondent : respondents) {
                if (reportCount.get(respondent) >= k) {
                    count++;
                }
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

