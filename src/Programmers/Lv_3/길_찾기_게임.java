package Programmers.Lv_3;

import java.util.Arrays;

public class 길_찾기_게임 {

    static int[][] answer;
    static int index;

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        System.out.println(Arrays.deepToString(solution(nodeinfo)));
    }

    public static int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }

        Arrays.sort(node);

        Node root = node[0];
        for (int i = 1; i < nodeinfo.length; i++) {
            insertNode(root, node[i]);
        }

        answer = new int[2][nodeinfo.length];
        index = 0;
        preorder(root);
        index = 0;
        postorder(root);

        return answer;
    }

    public static void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            answer[0][index] = root.v;
            index++;
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][index] = root.v;
            index++;
        }
    }

    public static class Node implements Comparable<Node> {

        int x;
        int y;
        int v;
        Node left;
        Node right;

        Node(int x, int y, int v, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return o.y - this.y;
        }
    }
}
