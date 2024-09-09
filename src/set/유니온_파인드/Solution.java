package set.유니온_파인드;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(x);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1; // root2 노드의 부모가 root1이 됨. (y가 속한 집합을 x가 속한 집합에 합침)
    }

    private static Boolean[] solution(int k, int[][] operations) {
        parent = new int[k];
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] operation : operations) {
            if (operation[0] == 0) {
                union(operation[1], operation[2]);
            } else {
                result.add(find(operation[1]) == find(operation[2]));
            }
        }

        return result.toArray(new Boolean[0]);
    }
}
