/*
https://leetcode.com/problems/find-duplicate-subtrees/

아이디어
DFS 로 최하위부터 상위로 String PreOrder 조합 ( Root 가 가장 앞 , Null 또한 포함 , ',' 로 각 값 구분 ) -> String 을 Key 로 숫자 카운트
 -> 기존에 있던 조합인 경우 정답에 포함, 또 추가가 안되도록 value 를 1 증가 시킴

자료구조
HashMap

시간복잡도
O(N)
*/

import java.util.*;

public class Solution {
    List<TreeNode> answer = new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);

        return answer;
    }

    public String dfs(TreeNode node) {
        if (node == null) return "null";

        String str = String.valueOf(node.val) + "," + dfs(node.left) + "," + dfs(node.right);

        if (!map.containsKey(str)) map.put(str, 1);
        else if (map.get(str) == 1) {
            answer.add(node);
            map.put(str, 2);
        }

        return str;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
