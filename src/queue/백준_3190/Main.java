package queue.백준_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<int[]> snake = new ArrayDeque<>();
    static Map<Integer, Character> moveInfo = new HashMap<>();
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row - 1][col - 1] = 'a'; // 사과 위치 표시
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            Character C = st.nextToken().charAt(0);
            moveInfo.put(X, C); // 방향 변환 정보 저장 (Key : 초, Value : L 또는 D)
        }

        int count = solution();

        System.out.println(count);
        br.close();
    }

    static int solution() {
        int count = 0;
        int y = 0, x = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int index = 0; // 오른쪽 방향으로 시작
        
        snake.offer(new int[]{y, x}); // 교보문고 E-book 찾아보기 // 꼬리부분 저장 (0, 0) 부터 시작하기 때문
        while (true) {
            count++; // 1. 초 증가

            int ny = y + dy[index];
            int nx = x + dx[index];

            for (int[] element : snake) { // 2-1. 머리가 자신의 몸에 닿는지 확인
                if (element[0] == ny && element[1] == nx) {
                    return count; // break를 하게되면 for문민 빠져나오고 while문을 빠져나오지 못함
                }
            }

            if (ny < 0 || nx < 0 || ny >= board.length || nx >= board.length) { // 2-2. 몸통이 밖으로 벗어나는지 확인
                break;
            }

            snake.offer(new int[]{ny, nx}); // 3. 머리 늘리기
            if (board[ny][nx] == 'a') {
                board[ny][nx] = ' '; // 사과를 먹었을 경우, 사과를 제거
            } else { // 사과를 먹지 못했을 경우, 꼬리 한 칸 제거
                snake.poll();
            }

            if (moveInfo.containsKey(count)) { // 4. 방향 전환정보가 있을 경우, 인덱스 변경
                if (moveInfo.get(count) == 'L') { // L일 경우, index++;
                    index++;
                    if (index >= 4) index -= 4;
                } else { // D일 경우, index--;
                    index--;
                    if (index < 0) index += 4;
                }
            }
            y = ny;
            x = nx;
        }
        return count;
    }
}
