## 문제

[2236. Root Equals Sum of Children](https://leetcode.com/problems/root-equals-sum-of-children/)

1. 시간복잡도: O(n)
2. 아이디어: 그냥 두개 더한기?
3. 자료구조:
4. 메모: 3개의 노드만 존재한다고 했으니 그냥 두개 더하는 방식으로 했다..

## 코드
  
class Solution {
    public boolean checkTree(TreeNode root) {
                    return root.val == root.left.val + root.right.val;

    }
}
