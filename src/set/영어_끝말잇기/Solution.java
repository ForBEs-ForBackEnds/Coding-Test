package set.영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        char beforeWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if ((beforeWord != currentWord.charAt(0)) || wordSet.contains(currentWord)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
                // 탈락자 번호와 탈락 라운드는 각각 모듈러 나누기 연산으로 쉽게 구할 수 있다. (이해가 안되면 words의 인덱스 표를 그려서 확인해보기)
            }
            wordSet.add(currentWord);
            beforeWord = currentWord.charAt(currentWord.length() - 1);
        }
        return new int[]{0, 0};
    }
}
