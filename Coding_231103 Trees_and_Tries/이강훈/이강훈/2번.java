/*
https://www.acmicpc.net/problem/5639

아이디어
트리 생성 ( 입력 첫번쨰 루트, 기준잡고 이후 값을 좌, 우 재귀 생성 ) -> 후위 순회

자료구조
트리

시간복잡도
O( log N + N ) // BST 생성 -> log N , 후위 순회 -> N
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()), null, null);

        String input;
        while ((input = br.readLine()) != null) {
            insert(root, new Node(Integer.parseInt(input), null, null));
        }

        postOrder(root);
        System.out.println(sb);
    }

    public static void insert(Node root, Node insertNode) {
        if (root.val > insertNode.val) {
            if (root.left == null) root.left = insertNode;
            else insert(root.left, insertNode);
        } else {
            if (root.right == null) root.right = insertNode;
            else insert(root.right, insertNode);
        }
    }

    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        sb.append(root.val).append("\n");
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
