package hash.베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Solution {

    /**
     * 해당 문제는 그림을 통해 순차적으로 접근해야 한다.
     * 장르의 이름을 키 값으로 갖는 해시 맵을 사용해야 하며, 각 노래를 특정 기준에 맞게 정렬할 수 있도록 내부에 ArrayList를 갖도록 한다.
     * 또한 별도의 Class를 선언하지 않고, int[]을 사용할 수 있다.
     *
     * 1. 장르의 이름과 총 재생 횟수를 관리하는 해시 맵
     * 2. 장르별로 (노래 번호, 재생 횟수)를 ArrayList를 관리하는 해시 맵
     *
     * 1번과 2번을 각각 스트림을 사용하여 특정 기준에 따라 내림차순한다.
     * -> 내림차순의 경우, 정해진 템플릿이 있기에 바로바로 사용할 수 있도록 숙지해둔다.
     */

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, ArrayList<int[]>> playMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, 0);
                playMap.put(genre, new ArrayList<>());
            }
            genreMap.put(genre, genreMap.get(genre) + play);
            playMap.get(genre).add(new int[]{i, play});
        }

        Stream<Entry<String, Integer>> sortedEntry = genreMap.entrySet().stream()
                                                             .sorted((o1, o2) -> Integer.compare(o2.getValue(),
                                                                 o1.getValue()));

        List<Integer> answer = new ArrayList<>();
        sortedEntry.forEach(entry -> {
            Stream<int[]> sortedPlay = playMap.get(entry.getKey())
                                              .stream()
                                              .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                                              .limit(2);
            sortedPlay.forEach(play -> answer.add(play[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
