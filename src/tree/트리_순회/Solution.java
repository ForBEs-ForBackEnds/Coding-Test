package tree.트리_순회;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        final String[] results = solution(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("results : " + Arrays.toString(results));
    }

    public static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();
        return result;
    }

    /**
     * 이진트리의 탐색 구현의 핵심
     * -> 전위/중위/후위에 따라 재귀 호출 순서가 달라짐.
     * --> 재귀 호출할 때 왼쪽 혹은 오른쪽 자식 노드의 인덱스 값이 반드시 들어가야함.
     */
    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        return nodes[idx] + " " +
            preorder(nodes, idx * 2 + 1) +
            preorder(nodes, idx * 2 + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        return inorder(nodes, idx * 2 + 1) +
            nodes[idx] + " " +
            inorder(nodes, idx * 2 + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        return postorder(nodes, idx * 2 + 1) +
            postorder(nodes, idx * 2 + 2) +
            nodes[idx] + " ";
    }
}
