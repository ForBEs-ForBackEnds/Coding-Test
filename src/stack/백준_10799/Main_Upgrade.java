package stack.백준_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Upgrade {

    /**
     * 개선한 알고리즘 정리
     * 스택 라이브러리를 사용할 경우, 스택의 엘리먼트를 모두 순회하는 부분 때문에 시간초과가 발생할 수 있다. O(N^2)
     * 따라서 O(N)으로 끝날 수 있도록 하려면 스택의 아이디어를 가져가되, 실제 스택을 구현하지 않고 값을 계산한다.
     *
     * 그림에서 보면 알 수 있듯이, 막대기가 점점 쌓이다가 레이저를 만나면 절단된다.
     * 즉, 쇠 막대기가 쌓이다가 레이저를 만나게 되면 그동안 쌓여있던 개수 만큼 절단 막대기가 생기는 것이다.
     * 실제로 스택에 쌓는 것이 아니라 그 개념만 가져가는 것이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0;
        int stickCount = 0;
        char[] chArray = s.toCharArray();

        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == '(') {
                stickCount += 1; // 스택에서 push에 해당함
            } else { // ')'일 때
                stickCount -= 1; // 스택에서 pop에 해당함
                if (chArray[i - 1] == '(') { // 레이저인 경우
                    sum += stickCount; // 레이저를 만나기 전까지 쌓여있던 쇠 막대기 개수 만큼 증가
                } else { // 쇠 막대기의 끝인 경우
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
