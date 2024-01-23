# https://leetcode.com/problems/binary-tree-inorder-traversal/

'''
1. 아이디어 :
    1. 왼쪽 끝까지 내려가면서 Stack을 채움
    2. 하나씩 뽑으면서 오른쪽 노드를 있는지 확인 후
    3. 있으면 왼쪽 끝까지 내려감
    4. 스택이 빌때까지 2~3을 반복
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    스택
'''

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 중위순회: 왼쪽 자식 -> 뿌리 -> 오른쪽 자식
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
        // 왼쪽 끝까지 내려감
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            node = temp.right;
            // 왼쪽 끝까지 내려감
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
        return list;
    }
}
