package tree.양과_늑대;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    private static ArrayList<Integer>[] tree;

    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges);

        int answer = 0;

        // BFS 초기 설정
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);
            now.visited.addAll(tree[now.node]);

            for (Integer next : now.visited) {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                if (info[next] == 1) {
                    if (now.sheep > now.wolf + 1) {
                        queue.offer(new Info(next, now.sheep, now.wolf + 1, set)); // 노드를 Queue에 넣는 다는 것은 해당 노드를 탐색한다는 뜻!
                    }
                } else {
                    queue.offer(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}
