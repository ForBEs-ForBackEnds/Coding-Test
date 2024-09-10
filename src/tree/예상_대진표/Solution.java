package tree.예상_대진표;

public class Solution {

    public static int solution(int n, int a, int b) {
        int answer;
        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}
