package stack.백준_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    /**
     * - ( )는 하나의 레이저를 뜻한다.
     * - 그 외의 괄호 쌍들은 하나의 쇠 막대기를 뜻한다.
     * 1. 하나의 쇠 막대기 안에 포함된 레이저 개수를 구한다.
     * 2. 잘려진 쇠 막대기 개수는 레이저 개수 + 1이다.
     *
     * 그렇다면, 어떻게 레이저와 쇠 막대기를 구분할 수 있을까?
     * 하나의 완전한 괄호 그룹은 여러 개의 레이저와 쇠 막대기를 갖고 있다.
     * 즉, (로 시작해서 )로 끝났다면, 이는 레이저와 쇠 막대기가 포함된 그룹을 나타내는 것이다.
     * 3. (로 시작해서 )로 끝나면 레이저다.
     * 4. 레이저가 한 개 발견될 경우, 먼저 쌓여있던 ( 칸에 레이저 개수를 1개씩 추가한다.
     * 5. 레이저가 아닌데 )로가 올 경우, 쇠 막대기가 끝나는 지점이며, 이 때는 총 레이저 개수 + 1로 잘린 막대 개수를 구한다.
     */

    /**
     * 알고리즘 정리
     * 1. '('가 올 경우, 스택에 저장한다.
     * 2. ')'가 올 경우, 먼저 레이저인지 확인한다.
     *  - 문자열에서 '('앞에 ')'가 있다면 이들은 레이저인 것이다.
     * 2-1. 만약, 레이저라면 스택에서 하나를 꺼낸 뒤, 스택의 맨 위칸부터 아래칸까지 레이저 개수를 1개씩 추가한다.
     * --> 시간초과가 발생할 수 있음. 따라서 스택을 순회하지 않고, 계산할 수 있도록 스택의 사이즈만큼을 막대 개수로 합산한다. (핵심 포인트)
     * 2-2. 만약, 레이저가 아니라면 스택에서 하나를 꺼낸 뒤, 꺼낸 '('가 갖고 있는 레이저 개수 + 1로 잘린 막대 개수를 구한 뒤, 총합에 더한다.
     * --> 쇠 막대기일 경우, 레이저에 의해 잘린 나머지 한 개가 있기에 막대 개수에 +1을 더한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0;
        char[] chArray = s.toCharArray();
        ArrayDeque<Element> stack = new ArrayDeque<>();

        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == '(') {
                stack.push(new Element('(', 0));
            } else {
                stack.pop();
                if (chArray[i - 1] == '(') { // 레이저일 경우
                    sum += stack.size();
                } else { // 레이저가 아니라 하나의 쇠 막대기일 경우
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }

    static class Element {

        public Character ch;

        public Integer raserCount;

        public Element(Character ch, Integer raserCount) {
            this.ch = ch;
            this.raserCount = raserCount;
        }
    }
}
