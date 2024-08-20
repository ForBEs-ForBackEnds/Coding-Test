package stack.백준_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int count = Integer.parseInt(br.readLine());

        ArrayDeque<Character> leftStack = new ArrayDeque<>();
        ArrayDeque<Character> rightStack = new ArrayDeque<>();

        for (Character c : line.toCharArray()) {
            leftStack.addLast(c);
        }

        while (count > 0) {
            String command = br.readLine();
            char ch = command.charAt(0);
            // 향상된 switch문, break 생략 가능
            switch (ch) {
                case 'L': {
                    if (!leftStack.isEmpty()) {
                        rightStack.addFirst(leftStack.removeLast());
                    }
                    break;
                }
                case 'D': {
                    if (!rightStack.isEmpty()) {
                        leftStack.addLast(rightStack.removeFirst());
                    }
                    break;
                }
                case 'B': {
                    if (!leftStack.isEmpty()) {
                        leftStack.removeLast();
                    }
                    break;
                }
                case 'P': {
                    char value = command.charAt(2);
                    leftStack.addLast(value);
                    break;
                }
            }
            count--;
        }

        for (Character c : leftStack) {
            bw.write(c);
        }

        for (Character c : rightStack) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
