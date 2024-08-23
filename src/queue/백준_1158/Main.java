package queue.백준_1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> tables = new ArrayDeque<>();
        Queue<Integer> result = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            tables.offer(i);
        }

        while (!tables.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                tables.offer(tables.poll());
            }
            result.offer(tables.poll());
        }

        char[] chars = result.toString().toCharArray();
        chars[0] = '<';
        chars[chars.length - 1] = '>';

        bw.write(chars);
        bw.flush();
        bw.close();
        br.close();
    }
}
